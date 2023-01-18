package ch.elca.candidateassess.rest;

import ch.elca.candidateassess.dto.SaveCandidateMarksDto;
import ch.elca.candidateassess.service.CandidateAnswerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/api/candidate-answers")
public class CandidateAnswerController {

    private final CandidateAnswerService candidateAnswerService;

    public CandidateAnswerController(CandidateAnswerService candidateAnswerService) {
        this.candidateAnswerService = candidateAnswerService;
    }


    @PutMapping("/saveMarks")
    public void saveCandidateMarks(@RequestBody SaveCandidateMarksDto saveCandidateMarksDto) {
        candidateAnswerService.saveCandidateMarks(saveCandidateMarksDto);
    }


}