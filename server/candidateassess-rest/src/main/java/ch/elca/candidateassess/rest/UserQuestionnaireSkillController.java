package ch.elca.candidateassess.rest;

import ch.elca.candidateassess.service.UserQuestionnaireSkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/api/user-questionnaire-skills")
public class UserQuestionnaireSkillController {

    private final UserQuestionnaireSkillService userQuestionnaireSkillService;

    public UserQuestionnaireSkillController(UserQuestionnaireSkillService userQuestionnaireSkillService) {
        this.userQuestionnaireSkillService = userQuestionnaireSkillService;
    }

}