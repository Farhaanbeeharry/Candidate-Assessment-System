/* tslint:disable */
/* eslint-disable */
// Generated using typescript-generator version 2.22.595 on 2022-01-10 13:58:13.

export class CandidateDto {
    id: string;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    emailAddress: string;
    remainingTime: number;
    position: PositionDto;
    userArchived: boolean;
    questionnaireStatus: QuestionnaireStatusEnum;
    skills: SelectedSkillDto[];
    reviewers: ReviewerDto[];
}

export class CandidateReviewDto {
    id: string;
    firstName: string;
    lastName: string;
    emailAddress: string;
    interviewDate: Date;
    questionnaire: QuestionnaireDto;
    timeTakenToCompleteQuestionnaire: number;
    marks: number;
    remainingTime: number;
}

export class CreateQuestionnaireDto {
    marks: number;
    totalTime: number;
    templateName: string;
}

export class CreateUserQuestionnaireDto {
    firstName: string;
    lastName: string;
    phoneNumber: string;
    emailAddress: string;
    marks: number;
    autoGenerate: boolean;
    remainingTime: number;
    timeTakenToCompleteQuestionnaire: number;
    candidateSelectSkills: boolean;
    token: string;
    interviewDate: Date;
    status: QuestionnaireStatusEnum;
    questionnaireId: string;
    positionId: string;
}

export class PositionDto {
    id: string;
    name: string;
}

export class QuestionForReviewDto {
    id: string;
    questionEnglish: string;
    questionFrench: string;
    marks: number;
}

export class QuestionnaireDataForReviewDto {
    candidateAnswerId: string;
    questionNumber: number;
    question: QuestionForReviewDto;
    textAnswer: string;
    marksAllocated: number;
}

export class QuestionnaireDto {
    id: string;
    marks: number;
    totalTime: number;
    templateName: string;
}

export class ReviewDto {
    id: string;
    personId: string;
    comment: string;
    status: ReviewStatusEnum;
    userQuestionnaireId: string;
}

export class ReviewerDto {
    id: string;
    firstName: string;
    lastName: string;
}

export class SaveReviewedUserQuestionnaireDto {
    comment: string;
    marks: number;
}

export class SelectedSkillDto {
    id: string;
    name: string;
    level: SkillLevelEnum;
}

export class SkillDto {
    id: string;
    name: string;
}

export enum AccountTypeEnum {
    ADMIN = 'ADMIN',
    HR = 'HR',
    REVIEWER = 'REVIEWER',
}

export enum QuestionnaireStatusEnum {
    QUESTIONNAIRE_NOT_GENERATED = 'QUESTIONNAIRE_NOT_GENERATED',
    PENDING = 'PENDING',
    UNDER_REVIEW = 'UNDER_REVIEW',
    COMPLETED = 'COMPLETED',
    DISQUALIFIED = 'DISQUALIFIED',
}

export enum ReviewStatusEnum {
    NEW = 'NEW',
    IN_PROGRESS = 'IN_PROGRESS',
    REVIEWED = 'REVIEWED',
}

export enum SkillLevelEnum {
    NOVICE = 'NOVICE',
    BEGINNER = 'BEGINNER',
    PROFICIENT = 'PROFICIENT',
    ADVANCED = 'ADVANCED',
    EXPERT = 'EXPERT',
}
