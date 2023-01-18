package ch.elca.candidateassess.rest;

import ch.elca.candidateassess.dto.AnswerDto;
import ch.elca.candidateassess.service.AnswerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Transactional
@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public void createAnswer(@RequestBody AnswerDto answerDto) {
        answerService.saveAnswer(answerDto);
    }

}