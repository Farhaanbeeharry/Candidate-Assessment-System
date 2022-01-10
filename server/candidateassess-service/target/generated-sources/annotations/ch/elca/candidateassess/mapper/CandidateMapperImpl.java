package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CandidateDto;
import ch.elca.candidateassess.dto.CandidateReviewDto;
import ch.elca.candidateassess.dto.CandidatesWhoAreNotAssignedInterviewDateDto;
import ch.elca.candidateassess.dto.PositionDto;
import ch.elca.candidateassess.dto.QuestionnaireDto;
import ch.elca.candidateassess.persistence.entity.Position;
import ch.elca.candidateassess.persistence.entity.Questionnaire;
import ch.elca.candidateassess.persistence.entity.UserQuestionnaire;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public CandidateDto mapToCandidateDto(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }

        CandidateDto candidateDto = new CandidateDto();

        candidateDto.setQuestionnaireStatus( userQuestionnaire.getStatus() );
        candidateDto.setId( userQuestionnaire.getId() );
        candidateDto.setFirstName( userQuestionnaire.getFirstName() );
        candidateDto.setLastName( userQuestionnaire.getLastName() );
        candidateDto.setPhoneNumber( userQuestionnaire.getPhoneNumber() );
        candidateDto.setEmailAddress( userQuestionnaire.getEmailAddress() );
        candidateDto.setRemainingTime( userQuestionnaire.getRemainingTime() );
        candidateDto.setPosition( positionToPositionDto( userQuestionnaire.getPosition() ) );
        candidateDto.setUserArchived( userQuestionnaire.getUserArchived() );

        return candidateDto;
    }

    @Override
    public CandidateReviewDto mapToCandidateReviewDto(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }

        CandidateReviewDto candidateReviewDto = new CandidateReviewDto();

        candidateReviewDto.setId( userQuestionnaire.getId() );
        candidateReviewDto.setFirstName( userQuestionnaire.getFirstName() );
        candidateReviewDto.setLastName( userQuestionnaire.getLastName() );
        candidateReviewDto.setEmailAddress( userQuestionnaire.getEmailAddress() );
        candidateReviewDto.setInterviewDate( userQuestionnaire.getInterviewDate() );
        candidateReviewDto.setQuestionnaire( questionnaireToQuestionnaireDto( userQuestionnaire.getQuestionnaire() ) );
        candidateReviewDto.setTimeTakenToCompleteQuestionnaire( userQuestionnaire.getTimeTakenToCompleteQuestionnaire() );
        if ( userQuestionnaire.getMarks() != null ) {
            candidateReviewDto.setMarks( userQuestionnaire.getMarks().intValue() );
        }
        candidateReviewDto.setRemainingTime( userQuestionnaire.getRemainingTime() );

        return candidateReviewDto;
    }

    @Override
    public CandidatesWhoAreNotAssignedInterviewDateDto mapToCandidatesWhoAreNotAssignedInterviewDateDto(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }

        CandidatesWhoAreNotAssignedInterviewDateDto candidatesWhoAreNotAssignedInterviewDateDto = new CandidatesWhoAreNotAssignedInterviewDateDto();

        candidatesWhoAreNotAssignedInterviewDateDto.setId( userQuestionnaire.getId() );
        candidatesWhoAreNotAssignedInterviewDateDto.setFirstName( userQuestionnaire.getFirstName() );
        candidatesWhoAreNotAssignedInterviewDateDto.setLastName( userQuestionnaire.getLastName() );
        candidatesWhoAreNotAssignedInterviewDateDto.setEmailAddress( userQuestionnaire.getEmailAddress() );
        candidatesWhoAreNotAssignedInterviewDateDto.setInterviewDate( userQuestionnaire.getInterviewDate() );

        return candidatesWhoAreNotAssignedInterviewDateDto;
    }

    protected PositionDto positionToPositionDto(Position position) {
        if ( position == null ) {
            return null;
        }

        PositionDto positionDto = new PositionDto();

        positionDto.setId( position.getId() );
        positionDto.setName( position.getName() );

        return positionDto;
    }

    protected QuestionnaireDto questionnaireToQuestionnaireDto(Questionnaire questionnaire) {
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
