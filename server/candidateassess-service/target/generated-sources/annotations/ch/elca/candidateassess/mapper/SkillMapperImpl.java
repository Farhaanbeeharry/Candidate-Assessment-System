package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateSkillDto;
import ch.elca.candidateassess.dto.DashboardDto;
import ch.elca.candidateassess.dto.SkillDto;
import ch.elca.candidateassess.persistence.entity.Skill;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public Skill mapToSkill(CreateSkillDto createSkillDto) {
        if ( createSkillDto == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setName( createSkillDto.getName() );

        return skill;
    }

    @Override
    public SkillDto mapToSkillDto(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillDto skillDto = new SkillDto();

        skillDto.setId( skill.getId() );
        skillDto.setName( skill.getName() );

        return skillDto;
    }

    @Override
    public DashboardDto mapToDashboardDto(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        DashboardDto dashboardDto = new DashboardDto();

        dashboardDto.setSkillName( skill.getName() );

        return dashboardDto;
    }
}
