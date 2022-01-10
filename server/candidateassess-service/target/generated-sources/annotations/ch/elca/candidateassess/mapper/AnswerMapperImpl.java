package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.AnswerDto;
import ch.elca.candidateassess.dto.FilledAnswerDto;
import ch.elca.candidateassess.dto.MultipleAnswerDto;
import ch.elca.candidateassess.dto.PossibleAnswerDto;
import ch.elca.candidateassess.persistence.entity.Answer;
import ch.elca.candidateassess.persistence.entity.Question;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer mapToAnswer(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setQuestion( answerDtoToQuestion( answerDto ) );
        answer.setAnswerEnglish( answerDto.getAnswerEnglish() );
        answer.setAnswerFrench( answerDto.getAnswerFrench() );
        answer.setValid( answerDto.getValid() );

        return answer;
    }

    @Override
    public AnswerDto mapToAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setQuestionId( answerQuestionId( answer ) );
        answerDto.setAnswerEnglish( answer.getAnswerEnglish() );
        answerDto.setAnswerFrench( answer.getAnswerFrench() );
        answerDto.setValid( answer.getValid() );

        return answerDto;
    }

    @Override
    public Answer mapToAnswerFromNewQuestionDto(MultipleAnswerDto multipleAnswerDto) {
        if ( multipleAnswerDto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setValid( multipleAnswerDto.getValue() );
        answer.setId( multipleAnswerDto.getId() );
        answer.setAnswerEnglish( multipleAnswerDto.getAnswerEnglish() );
        answer.setAnswerFrench( multipleAnswerDto.getAnswerFrench() );

        return answer;
    }

    @Override
    public PossibleAnswerDto mapToPossibleAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        PossibleAnswerDto possibleAnswerDto = new PossibleAnswerDto();

        possibleAnswerDto.setId( answer.getId() );
        possibleAnswerDto.setAnswerEnglish( answer.getAnswerEnglish() );
        possibleAnswerDto.setAnswerFrench( answer.getAnswerFrench() );

        return possibleAnswerDto;
    }

    @Override
    public MultipleAnswerDto mapToMultipleAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        MultipleAnswerDto multipleAnswerDto = new MultipleAnswerDto();

        multipleAnswerDto.setId( answer.getId() );
        multipleAnswerDto.setAnswerEnglish( answer.getAnswerEnglish() );
        multipleAnswerDto.setAnswerFrench( answer.getAnswerFrench() );

        return multipleAnswerDto;
    }

    @Override
    public FilledAnswerDto mapToFilledAnswerDto(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        FilledAnswerDto filledAnswerDto = new FilledAnswerDto();

        filledAnswerDto.setAnswerEnglish( answer.getAnswerEnglish() );
        filledAnswerDto.setValid( answer.getValid() );

        return filledAnswerDto;
    }

    protected Question answerDtoToQuestion(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( answerDto.getQuestionId() );

        return question;
    }

    private UUID answerQuestionId(Answer answer) {
        if ( answer == null ) {
            return null;
        }
        Question question = answer.getQuestion();
        if ( question == null ) {
            return null;
        }
        UUID id = question.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
