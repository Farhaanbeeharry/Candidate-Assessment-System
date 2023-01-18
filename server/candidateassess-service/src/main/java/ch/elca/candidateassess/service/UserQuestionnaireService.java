package ch.elca.candidateassess.service;

import ch.elca.candidateassess.dto.*;

import java.util.UUID;

public interface UserQuestionnaireService {

    UserQuestionnaireDto saveUserQuestionnaire(CreateUserQuestionnaireDto createUserQuestionnaireDto);

    void updateUserQuestionnaire(UpdateUserQuestionnaireDto updateUserQuestionnaireDto, String userQuestionnaireId);

    void inviteCandidate(InviteCandidateDto candidateDto);

    void saveReviewedUserQuestionnaire(SaveReviewedUserQuestionnaireDto saveReviewedUserQuestionnaireDto, UUID userQuestionnaireId);

    void validateId(UUID userQuestionnaireId);

    void validateIdAndUnderReview(UUID userQuestionnaireId);
}