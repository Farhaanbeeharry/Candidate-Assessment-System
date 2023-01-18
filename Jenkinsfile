def VERSION
def ENABLE_DEPLOYMENT

pipeline {
    agent {
        kubernetes {
            yaml(
                elcaBuildYamlPod(containers: [
                    elcaContainers.precommit(),
                    elcaContainers.oc(),
                    elcaContainers.maven(tag: '3.8.5-eclipse-temurin-11'),
                    elcaContainers.node(tag: '14.21.1', requestMemory: '3072Mi', limitMemory: '3072Mi'),
                    elcaContainers.sonarscanner(),
                ])
            )
        }
    }
    parameters {
        choice(name: 'environment', choices: ['dev', 'int', 'external'], description: 'The environment to perform the deployment to')
    }
    environment {
        MAVEN_OPTIONS = '-B -U -V'
        MAVEN_SETTINGS = 'global-maven'
        NPM_SETTINGS = 'global-npm'
        FORMATTED_DATE = "${elcaGetFormattedDate()}"

        // OKD Context

        OKD_NAMESPACE = "prj-elcamulab"
        OKD_CLUSTER = 'default'
        OKD_APP_ID = "${elcaGetLocalGitBranch()}"

        // App Context

        APP_NAME = "candidate-assessment"

        BACKEND_MODULE = "server"
        BACKEND_HOST = "${APP_NAME}-${BACKEND_MODULE}-${OKD_APP_ID}-${OKD_NAMESPACE}.apps.okd.svc.elca.ch"

        FRONTEND_MODULE = "web"
        FRONTEND_HOST = "${APP_NAME}-${FRONTEND_MODULE}-${OKD_APP_ID}-${OKD_NAMESPACE}.apps.okd.svc.elca.ch"
    }
    options {
        disableConcurrentBuilds()
        timeout(time: 60, unit: 'MINUTES')
    }
    stages {
        stage('Initialize') {
            steps {
                script {
                    VERSION = "${env.OKD_APP_ID}"
                    ENABLE_DEPLOYMENT = "${elcaGetLocalGitBranch()}" == 'develop'
                }
            }
        }
        stage('Build') {
            stages {
                stage('Backend build') {
                    steps {
                        dir(env.BACKEND_MODULE) {
                            elcaMavenCommand(goals: 'clean verify')
                        }
                    }
                }
                stage('Node versions') {
                    steps {
                        elcaNodeCommand(binary: 'node', command: '--version')
                    }
                }
                stage('Frontend build') {
                    steps {
                        dir(env.FRONTEND_MODULE) {
                            elcaNodeCommand(binary: 'npm', command: 'install', options: '--force --omit=optional --no-audit')
                            elcaNodeCommand(binary: 'npx', command: 'ng build')
                        }
                    }
                }
            }
        }
        stage('Sonarqube') {
            parallel {
                stage('Sonarqube backend') {
                    steps {
                        dir(env.BACKEND_MODULE) {
                            elcaSonarQubeMaven()
                            elcaWaitForQualityGate(failOnQualityGate: false, skip: true)
                        }
                    }
                }
                stage('Sonarqube frontend') {
                    steps {
                        dir(env.FRONTEND_MODULE) {
                            elcaSonarQubeScanner(
                                projectKey: "${env.APP_NAME}-${env.FRONTEND_MODULE}",
                                projectName: "${env.APP_NAME}-${env.FRONTEND_MODULE}",
                                // nodeTool: 'nodejs-16',
                                profile: elcaSonarQubeProfiles.nodeJs()
                            )
                            elcaWaitForQualityGate(failOnQualityGate: false, skip: true)
                        }
                    }
                }
            }
        }
        stage('Prepare deployment') {
            steps {
                elcaOKDConfigureLock(oc: openshift)
                elcaWithOKD(oc: openshift) { openshift ->
                    script {
                        openshift.selector('route', [app: "${env.APP_NAME}-${env.OKD_APP_ID}"]).delete()
                    }
                }
                elcaOKDDeleteAll(
                    oc: openshift,
                    selector: [app: "${env.APP_NAME}-${env.OKD_APP_ID}"],
                    withConfigMaps: true,
                    withSecrets: false,
                    withVolumes: true,
                )
            }
        }
        stage('Package') {
            parallel {
                stage('Backend container') {
                    when {
                        expression { ENABLE_DEPLOYMENT == true }
                    }
                    steps {
                        elcaWithArtifactoryCredentials {
                            dir(env.BACKEND_MODULE) {
                                elcaMavenCommand(goals: "package -P docker-build -Djib.httpTimeout=120000 -DcontainerImageName=${env.OKD_NAMESPACE}-docker.artifactory.svc.elca.ch/${env.APP_NAME}/${env.BACKEND_MODULE} -DcontainerImageVersion=${VERSION}")
                            }
                        }
                    }
                }
                stage('Frontend container') {
                    when {
                        expression { ENABLE_DEPLOYMENT == true }
                    }
                    steps {
                        dir(env.FRONTEND_MODULE) {
                            fileOperations([
                                folderCreateOperation(folderPath: 'build'),
                                fileCopyOperation(includes: 'docker/*', targetLocation: 'build', flattenFiles: true),
                                fileCopyOperation(includes: 'nginx/*', targetLocation: 'build', flattenFiles: true),
                                folderCopyOperation(sourceFolderPath: 'dist', destinationFolderPath: 'build/dist'),
                            ])
                            // Build
                            elcaDockerBuild(
                                oc: openshift,
                                metadataName: "${env.APP_NAME}-${env.FRONTEND_MODULE}-${env.OKD_APP_ID}",
                                folder: 'build',
                                buildFile: 'okd/build.yml',
                                containerImageName: "${env.OKD_NAMESPACE}-docker.artifactory.svc.elca.ch/${env.APP_NAME}/${env.FRONTEND_MODULE}:${VERSION}",
                                templateParams: [
                                    'APP_NAME'          : env.APP_NAME,
                                    'FRONTEND_MODULE'   : env.FRONTEND_MODULE,
                                    'OKD_APP_ID'        : env.OKD_APP_ID,
                                    'OKD_NAMESPACE'     : env.OKD_NAMESPACE,
                                    'VERSION'           : "${VERSION}"
                                ]
                            )
                        }
                    }
                }
            }
        }
        stage('Deploy backend') {
            when {
                expression { ENABLE_DEPLOYMENT == true }
            }
            steps {
                elcaOKDApplyTemplate(
                    oc: openshift,
                    templateFile: "${env.BACKEND_MODULE}/okd/configmap.yml",
                    templateParams: [
                        'APP_NAME'          : env.APP_NAME,
                        'BACKEND_MODULE'    : env.BACKEND_MODULE,
                        'OKD_APP_ID'        : env.OKD_APP_ID,
                        'FRONTEND_HOST'     : "http://${env.FRONTEND_HOST}"
                    ]
                )
                elcaOKDApplyTemplate(
                    oc: openshift,
                    templateFile: "${env.BACKEND_MODULE}/okd/deploy.yml",
                    templateParams: [
                        'APP_NAME'          : env.APP_NAME,
                        'BACKEND_MODULE'    : env.BACKEND_MODULE,
                        'BACKEND_HOST'      : env.BACKEND_HOST,
                        'FORMATTED_DATE'    : env.FORMATTED_DATE,
                        'OKD_APP_ID'        : env.OKD_APP_ID,
                        'OKD_NAMESPACE'     : env.OKD_NAMESPACE,
                        'VERSION'           : "${VERSION}"
                    ],
                )
            }
        }
        stage('Deploy frontend') {
            when {
                expression { ENABLE_DEPLOYMENT == true }
            }
            steps {
                elcaOKDApplyTemplate(
                    oc: openshift,
                    templateFile: "${env.FRONTEND_MODULE}/okd/deploy.yml",
                    templateParams: [
                        'APP_NAME'          : env.APP_NAME,
                        'BACKEND_HOST'      : env.BACKEND_HOST,
                        'BACKEND_MODULE'    : env.BACKEND_MODULE,
                        'FRONTEND_HOST'     : env.FRONTEND_HOST,
                        'FRONTEND_MODULE'   : env.FRONTEND_MODULE,
                        'OKD_APP_ID'        : env.OKD_APP_ID,
                        'OKD_NAMESPACE'     : env.OKD_NAMESPACE,
                        'FORMATTED_DATE'    : env.FORMATTED_DATE,
                        'VERSION'           : "${VERSION}"
                    ]
                )
            }
        }
        stage('Wait for application') {
            when {
                expression { ENABLE_DEPLOYMENT == true }
            }
            steps {
                // This will ensure routes are accepted
                elcaOKDEnsureRouteAvailable(name: "${env.APP_NAME}-${env.BACKEND_MODULE}-${env.OKD_APP_ID}", oc: openshift)
                elcaOKDEnsureRouteAvailable(name: "${env.APP_NAME}-${env.FRONTEND_MODULE}-${env.OKD_APP_ID}", oc: openshift)

                // Wait for frontend
                elcaOKDWaitForDeploymentConfig(deploymentName: "${env.APP_NAME}-${env.FRONTEND_MODULE}-${env.OKD_APP_ID}", oc: openshift)
                elcaWaitForHttpStatusCode(url: "http://${env.FRONTEND_HOST}", time: 60)

                // Wait for backend
                elcaOKDWaitForDeploymentConfig(deploymentName: "${env.APP_NAME}-${env.BACKEND_MODULE}-${env.OKD_APP_ID}", oc: openshift)
                elcaWaitForHttpStatusCode(url: "http://${env.BACKEND_HOST}/actuator/health", time: 60)
            }
        }
    }
    post {
        changed {
            elcaEmail()
        }
        always {
            recordIssues(
                id: 'maven-warnings',
                name: 'Maven Warnings Trend',
                trendChartType: 'TOOLS_ONLY',
                tools: [
                    mavenConsole(),
                ]
            )
        }
    }
}