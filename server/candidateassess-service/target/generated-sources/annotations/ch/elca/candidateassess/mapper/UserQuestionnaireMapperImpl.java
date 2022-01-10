package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateUserQuestionnaireDto;
import ch.elca.candidateassess.dto.FilledQuestionnaireDto;
import ch.elca.candidateassess.dto.InviteCandidateDto;
import ch.elca.candidateassess.dto.SaveReviewedUserQuestionnaireDto;
import ch.elca.candidateassess.dto.UpdateUserQuestionnaireDto;
import ch.elca.candidateassess.dto.UserQuestionnaireDto;
import ch.elca.candidateassess.dto.ValidateTokenDto;
import ch.elca.candidateassess.persistence.entity.Position;
import ch.elca.candidateassess.persistence.entity.Questionnaire;
import ch.elca.candidateassess.persistence.entity.UserQuestionnaire;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class UserQuestionnaireMapperImpl implements UserQuestionnaireMapper {

    @Override
    public UserQuestionnaire mapToUserQuestionnaire(CreateUserQuestionnaireDto createUserQuestionnaireDto) {
        if ( createUserQuestionnaireDto == null ) {
            return null;
        }

        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();

        userQuestionnaire.setFirstName( createUserQuestionnaireDto.getFirstName() );
        userQuestionnaire.setLastName( createUserQuestionnaireDto.getLastName() );
        userQuestionnaire.setPhoneNumber( createUserQuestionnaireDto.getPhoneNumber() );
        userQuestionnaire.setEmailAddress( createUserQuestionnaireDto.getEmailAddress() );
        if ( createUserQuestionnaireDto.getMarks() != null ) {
            userQuestionnaire.setMarks( createUserQuestionnaireDto.getMarks().doubleValue() );
        }
        userQuestionnaire.setTimeTakenToCompleteQuestionnaire( createUserQuestionnaireDto.getTimeTakenToCompleteQuestionnaire() );
        userQuestionnaire.setRemainingTime( createUserQuestionnaireDto.getRemainingTime() );
        userQuestionnaire.setToken( createUserQuestionnaireDto.getToken() );
        userQuestionnaire.setCandidateSelectSkills( createUserQuestionnaireDto.getCandidateSelectSkills() );
        userQuestionnaire.setAutoGenerate( createUserQuestionnaireDto.getAutoGenerate() );
        userQuestionnaire.setInterviewDate( createUserQuestionnaireDto.getInterviewDate() );
        userQuestionnaire.setStatus( createUserQuestionnaireDto.getStatus() );

        return userQuestionnaire;
    }

    @Override
    public UserQuestionnaireDto mapToUserQuestionnaireDto(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }

        UserQuestionnaireDto userQuestionnaireDto = new UserQuestionnaireDto();

        userQuestionnaireDto.setPositionId( userQuestionnairePositionId( userQuestionnaire ) );
        userQuestionnaireDto.setQuestionnaireId( userQuestionnaireQuestionnaireId( userQuestionnaire ) );
        userQuestionnaireDto.setId( userQuestionnaire.getId() );
        userQuestionnaireDto.setFirstName( userQuestionnaire.getFirstName() );
        userQuestionnaireDto.setLastName( userQuestionnaire.getLastName() );
        userQuestionnaireDto.setPhoneNumber( userQuestionnaire.getPhoneNumber() );
        userQuestionnaireDto.setEmailAddress( userQuestionnaire.getEmailAddress() );
        if ( userQuestionnaire.getMarks() != null ) {
            userQuestionnaireDto.setMarks( userQuestionnaire.getMarks().intValue() );
        }
        userQuestionnaireDto.setTimeTakenToCompleteQuestionnaire( userQuestionnaire.getTimeTakenToCompleteQuestionnaire() );
        userQuestionnaireDto.setRemainingTime( userQuestionnaire.getRemainingTime() );
        userQuestionnaireDto.setToken( userQuestionnaire.getToken() );
        userQuestionnaireDto.setInterviewDate( userQuestionnaire.getInterviewDate() );
        userQuestionnaireDto.setStatus( userQuestionnaire.getStatus() );

        return userQuestionnaireDto;
    }

    @Override
    public void mapUpdateUserQuestionnaireDtoToExistingUserQuestionnaire(UserQuestionnaire userQuestionnaire, UpdateUserQuestionnaireDto updateUserQuestionnaireDto) {
        if ( updateUserQuestionnaireDto == null ) {
            return;
        }

        userQuestionnaire.setFirstName( updateUserQuestionnaireDto.getFirstName() );
        userQuestionnaire.setLastName( updateUserQuestionnaireDto.getLastName() );
        userQuestionnaire.setPhoneNumber( updateUserQuestionnaireDto.getPhoneNumber() );
        userQuestionnaire.setEmailAddress( updateUserQuestionnaireDto.getEmailAddress() );
    }

    @Override
    public void mapInviteCandidateDtoToExistingUserQuestionnaire(UserQuestionnaire userQuestionnaire, InviteCandidateDto inviteCandidateDto) {
        if ( inviteCandidateDto == null ) {
            return;
        }

        userQuestionnaire.setId( inviteCandidateDto.getId() );
        if ( inviteCandidateDto.getInterviewDate() != null ) {
            userQuestionnaire.setInterviewDate( LocalDateTime.ofInstant( inviteCandidateDto.getInterviewDate().toInstant(), ZoneId.of( "UTC" ) ) );
        }
        else {
            userQuestionnaire.setInterviewDate( null );
        }
    }

    @Override
    public FilledQuestionnaireDto mapToFilledQuestionnaireDto(FilledQuestionnaireDto filledQuestionnaireDto, UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }

        filledQuestionnaireDto.setMarksObtained( userQuestionnaire.getMarks() );
        filledQuestionnaireDto.setTimeTaken( userQuestionnaire.getTimeTakenToCompleteQuestionnaire() );
        filledQuestionnaireDto.setFirstName( userQuestionnaire.getFirstName() );
        filledQuestionnaireDto.setLastName( userQuestionnaire.getLastName() );
        filledQuestionnaireDto.setMarks( userQuestionnaire.getMarks() );

        return filledQuestionnaireDto;
    }

    @Override
    public void mapToValidateToken(ValidateTokenDto validateTokenDto, UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return;
        }

        validateTokenDto.setUserQuestionnaireId( userQuestionnaire.getId() );
        validateTokenDto.setCandidateSelectSkills( userQuestionnaire.getCandidateSelectSkills() );
        validateTokenDto.setIsAttempted( userQuestionnaire.getIsAttempted() );
    }

    @Override
    public void mapSaveReviewedUserQuestionnaireDtoToExistingUserQuestionnaire(UserQuestionnaire userQuestionnaire, SaveReviewedUserQuestionnaireDto saveReviewedUserQuestionnaireDto) {
        if ( saveReviewedUserQuestionnaireDto == null ) {
            return;
        }

        userQuestionnaire.setMarks( saveReviewedUserQuestionnaireDto.getMarks() );
        userQuestionnaire.setComment( saveReviewedUserQuestionnaireDto.getComment() );
    }

    private UUID userQuestionnairePositionId(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }
        Position position = userQuestionnaire.getPosition();
        if ( position == null ) {
            return null;
        }
        UUID id = position.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private UUID userQuestionnaireQuestionnaireId(UserQuestionnaire userQuestionnaire) {
        if ( userQuestionnaire == null ) {
            return null;
        }
        Questionnaire questionnaire = userQuestionnaire.getQuestionnaire();
        if ( questionnaire == null ) {
            return null;
        }
        UUID id = questionnaire.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
