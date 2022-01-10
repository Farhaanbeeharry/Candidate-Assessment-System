package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateCandidateAnswerDto;
import ch.elca.candidateassess.dto.QuestionForReviewDto;
import ch.elca.candidateassess.dto.QuestionnaireDataForReviewDto;
import ch.elca.candidateassess.persistence.entity.CandidateAnswer;
import ch.elca.candidateassess.persistence.entity.Question;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class CandidateAnswerMapperImpl implements CandidateAnswerMapper {

    @Override
    public CandidateAnswer mapToCandidateAnswer(CreateCandidateAnswerDto createCandidateAnswerDto) {
        if ( createCandidateAnswerDto == null ) {
            return null;
        }

        CandidateAnswer candidateAnswer = new CandidateAnswer();

        candidateAnswer.setTextAnswer( createCandidateAnswerDto.getTextAnswer() );

        return candidateAnswer;
    }

    @Override
    public void mapToQuestionnaireDataForReviewDto(QuestionnaireDataForReviewDto questionnaireDataForReviewDto, CandidateAnswer candidateAnswer) {
        if ( candidateAnswer == null ) {
            return;
        }

        questionnaireDataForReviewDto.setCandidateAnswerId( candidateAnswer.getId() );
        if ( candidateAnswer.getQuestion() != null ) {
            if ( questionnaireDataForReviewDto.getQuestion() == null ) {
                questionnaireDataForReviewDto.setQuestion( new QuestionForReviewDto() );
            }
            questionToQuestionForReviewDto( candidateAnswer.getQuestion(), questionnaireDataForReviewDto.getQuestion() );
        }
        else {
            questionnaireDataForReviewDto.setQuestion( null );
        }
        questionnaireDataForReviewDto.setTextAnswer( candidateAnswer.getTextAnswer() );
        questionnaireDataForReviewDto.setMarksAllocated( candidateAnswer.getMarksAllocated() );
    }

    protected void questionToQuestionForReviewDto(Question question, QuestionForReviewDto mappingTarget) {
        if ( question == null ) {
            return;
        }

        mappingTarget.setId( question.getId() );
        mappingTarget.setQuestionEnglish( question.getQuestionEnglish() );
        mappingTarget.setQuestionFrench( question.getQuestionFrench() );
        if ( question.getMarks() != null ) {
            mappingTarget.setMarks( question.getMarks().intValue() );
        }
        else {
            mappingTarget.setMarks( null );
        }
    }
}
