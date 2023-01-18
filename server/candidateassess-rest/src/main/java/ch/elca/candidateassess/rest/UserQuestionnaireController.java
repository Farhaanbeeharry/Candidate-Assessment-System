package ch.elca.candidateassess.rest;

import ch.elca.candidateassess.dto.*;
import ch.elca.candidateassess.service.UserQuestionnaireService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
@RestController
@RequestMapping("/api/user-questionnaires")
public class UserQuestionnaireController {

    private final UserQuestionnaireService userQuestionnaireService;

    public UserQuestionnaireController(UserQuestionnaireService userQuestionnaireService) {
        this.userQuestionnaireService = userQuestionnaireService;
    }

    @GetMapping("/validateId/{userQuestionnaireId}")
    public void validateId(@PathVariable UUID userQuestionnaireId) {
        userQuestionnaireService.validateId(userQuestionnaireId);
    }

    @GetMapping("/validateIdAndUnderReview/{userQuestionnaireId}")
    public void validateIdAndUnderReview(@PathVariable UUID userQuestionnaireId) {
        userQuestionnaireService.validateIdAndUnderReview(userQuestionnaireId);
    }

    @PutMapping("/saveReviewedUserQuestionnaire/{userQuestionnaireId}")
    public void saveReviewedUserQuestionnaire(@RequestBody SaveReviewedUserQuestionnaireDto saveReviewedUserQuestionnaireDto, @PathVariable("userQuestionnaireId") UUID userQuestionnaireId) {
        userQuestionnaireService.saveReviewedUserQuestionnaire(saveReviewedUserQuestionnaireDto, userQuestionnaireId);
    }

    @PutMapping("/inviteCandidate/{userQuestionnaireId}")
    public void inviteCandidate(@RequestBody InviteCandidateDto inviteCandidateDto, @PathVariable("userQuestionnaireId") String userQuestionnaireId) {
        userQuestionnaireService.inviteCandidate(inviteCandidateDto);
    }

    @PutMapping("/update/{userQuestionnaireId}")
    public void createUserQuestionnaire(@RequestBody UpdateUserQuestionnaireDto updateUserQuestionnaireDto, @PathVariable("userQuestionnaireId") String userQuestionnaireId) {
        userQuestionnaireService.updateUserQuestionnaire(updateUserQuestionnaireDto, userQuestionnaireId);
    }

    @PostMapping
    public UserQuestionnaireDto createUserQuestionnaire(@RequestBody CreateUserQuestionnaireDto createUserQuestionnaireDto) {
        return userQuestionnaireService.saveUserQuestionnaire(createUserQuestionnaireDto);
    }

}