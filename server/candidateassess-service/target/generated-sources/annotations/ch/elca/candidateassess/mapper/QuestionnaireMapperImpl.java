package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateQuestionnaireDto;
import ch.elca.candidateassess.dto.QuestionnaireDto;
import ch.elca.candidateassess.persistence.entity.Questionnaire;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class QuestionnaireMapperImpl implements QuestionnaireMapper {

    @Override
    public Questionnaire mapToQuestionnaire(CreateQuestionnaireDto createQuestionnaireDto) {
        if ( createQuestionnaireDto == null ) {
            return null;
        }

        Questionnaire questionnaire = new Questionnaire();

        questionnaire.setTemplateName( createQuestionnaireDto.getTemplateName() );
        if ( createQuestionnaireDto.getMarks() != null ) {
            questionnaire.setMarks( createQuestionnaireDto.getMarks().doubleValue() );
        }
        questionnaire.setTotalTime( createQuestionnaireDto.getTotalTime() );

        return questionnaire;
    }

    @Override
    public QuestionnaireDto mapToQuestionnaireDto(Questionnaire questionnaire) {
        if ( questionnaire == null ) {
            return null;
        }

        QuestionnaireDto questionnaireDto = new QuestionnaireDto();

        questionnaireDto.setId( questionnaire.getId() );
        if ( questionnaire.getMarks() != null ) {
            questionnaireDto.setMarks( questionnaire.getMarks().intValue() );
        }
        questionnaireDto.setTotalTime( questionnaire.getTotalTime() );
        questionnaireDto.setTemplateName( questionnaire.getTemplateName() );

        return questionnaireDto;
    }
}
