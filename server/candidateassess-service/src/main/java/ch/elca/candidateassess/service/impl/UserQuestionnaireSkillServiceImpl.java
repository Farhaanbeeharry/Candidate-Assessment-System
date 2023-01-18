package ch.elca.candidateassess.service.impl;

import ch.elca.candidateassess.dto.CreateUserQuestionnaireSkillDto;
import ch.elca.candidateassess.mapper.UserQuestionnaireSkillMapper;
import ch.elca.candidateassess.persistence.entity.Skill;
import ch.elca.candidateassess.persistence.entity.UserQuestionnaire;
import ch.elca.candidateassess.persistence.entity.UserQuestionnaireSkill;
import ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum;
import ch.elca.candidateassess.persistence.repository.SkillRepository;
import ch.elca.candidateassess.persistence.repository.UserQuestionnaireRepository;
import ch.elca.candidateassess.persistence.repository.UserQuestionnaireSkillRepository;
import ch.elca.candidateassess.service.UserQuestionnaireSkillService;
import org.springframework.stereotype.Service;

@Service
public class UserQuestionnaireSkillServiceImpl implements UserQuestionnaireSkillService {

    private final UserQuestionnaireSkillRepository userQuestionnaireSkillRepository;
    private final UserQuestionnaireRepository userQuestionnaireRepository;
    private final SkillRepository skillRepository;
    private final UserQuestionnaireSkillMapper userQuestionnaireSkillMapper;

    public UserQuestionnaireSkillServiceImpl(UserQuestionnaireSkillRepository userQuestionnaireSkillRepository, UserQuestionnaireRepository userQuestionnaireRepository, SkillRepository skillRepository, UserQuestionnaireSkillMapper userQuestionnaireSkillMapper) {
        this.userQuestionnaireSkillRepository = userQuestionnaireSkillRepository;
        this.userQuestionnaireRepository = userQuestionnaireRepository;
        this.skillRepository = skillRepository;
        this.userQuestionnaireSkillMapper = userQuestionnaireSkillMapper;
    }


}