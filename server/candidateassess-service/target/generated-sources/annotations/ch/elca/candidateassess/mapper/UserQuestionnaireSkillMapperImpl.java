package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.SelectedSkillDto;
import ch.elca.candidateassess.dto.SkillLevelDto;
import ch.elca.candidateassess.persistence.entity.Skill;
import ch.elca.candidateassess.persistence.entity.UserQuestionnaireSkill;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class UserQuestionnaireSkillMapperImpl implements UserQuestionnaireSkillMapper {

    @Override
    public SelectedSkillDto mapToSelectedSkillDto(UserQuestionnaireSkill userQuestionnaireSkill) {
        if ( userQuestionnaireSkill == null ) {
            return null;
        }

        SelectedSkillDto selectedSkillDto = new SelectedSkillDto();

        selectedSkillDto.setName( userQuestionnaireSkillSkillName( userQuestionnaireSkill ) );
        selectedSkillDto.setId( userQuestionnaireSkillSkillId( userQuestionnaireSkill ) );
        selectedSkillDto.setLevel( userQuestionnaireSkill.getLevel() );

        return selectedSkillDto;
    }

    @Override
    public SkillLevelDto mapToSkillLevelDto(UserQuestionnaireSkill userQuestionnaireSkill) {
        if ( userQuestionnaireSkill == null ) {
            return null;
        }

        SkillLevelDto skillLevelDto = new SkillLevelDto();

        skillLevelDto.setSkill( userQuestionnaireSkill.getSkill() );
        skillLevelDto.setLevel( userQuestionnaireSkill.getLevel() );

        return skillLevelDto;
    }

    private String userQuestionnaireSkillSkillName(UserQuestionnaireSkill userQuestionnaireSkill) {
        if ( userQuestionnaireSkill == null ) {
            return null;
        }
        Skill skill = userQuestionnaireSkill.getSkill();
        if ( skill == null ) {
            return null;
        }
        String name = skill.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private UUID userQuestionnaireSkillSkillId(UserQuestionnaireSkill userQuestionnaireSkill) {
        if ( userQuestionnaireSkill == null ) {
            return null;
        }
        Skill skill = userQuestionnaireSkill.getSkill();
        if ( skill == null ) {
            return null;
        }
        UUID id = skill.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
