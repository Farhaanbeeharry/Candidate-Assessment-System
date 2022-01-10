package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateQuestionnaireQuestionDto;
import ch.elca.candidateassess.dto.FilledQuestionDto;
import ch.elca.candidateassess.dto.QuestionForReviewDto;
import ch.elca.candidateassess.dto.QuestionnaireDataForReviewDto;
import ch.elca.candidateassess.persistence.entity.Question;
import ch.elca.candidateassess.persistence.entity.QuestionnaireQuestion;
import ch.elca.candidateassess.persistence.entity.Skill;
import ch.elca.candidateassess.persistence.enumeration.QuestionTypeEnum;
import ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class QuestionnaireQuestionMapperImpl implements QuestionnaireQuestionMapper {

    @Override
    public QuestionnaireQuestion mapToQuestionnaireQuestion(CreateQuestionnaireQuestionDto createQuestionnaireQuestionDto) {
        if ( createQuestionnaireQuestionDto == null ) {
            return null;
        }

        QuestionnaireQuestion questionnaireQuestion = new QuestionnaireQuestion();

        questionnaireQuestion.setQuestionNumber( createQuestionnaireQuestionDto.getQuestionNumber() );

        return questionnaireQuestion;
    }

    @Override
    public QuestionnaireDataForReviewDto mapToQuestionnaireDataForReviewDto(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }

        QuestionnaireDataForReviewDto questionnaireDataForReviewDto = new QuestionnaireDataForReviewDto();

        questionnaireDataForReviewDto.setQuestionNumber( questionnaireQuestion.getQuestionNumber() );
        questionnaireDataForReviewDto.setQuestion( questionToQuestionForReviewDto( questionnaireQuestion.getQuestion() ) );

        return questionnaireDataForReviewDto;
    }

    @Override
    public FilledQuestionDto mapToFilledQuestionDto(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }

        FilledQuestionDto filledQuestionDto = new FilledQuestionDto();

        filledQuestionDto.setSkillName( questionnaireQuestionQuestionSkillName( questionnaireQuestion ) );
        filledQuestionDto.setQuestion( questionnaireQuestionQuestionQuestionEnglish( questionnaireQuestion ) );
        filledQuestionDto.setMarks( questionnaireQuestionQuestionMarks( questionnaireQuestion ) );
        filledQuestionDto.setQuestionType( questionnaireQuestionQuestionType( questionnaireQuestion ) );
        filledQuestionDto.setSkillLevel( questionnaireQuestionQuestionSkillLevel( questionnaireQuestion ) );
        filledQuestionDto.setQuestionNumber( questionnaireQuestion.getQuestionNumber() );

        return filledQuestionDto;
    }

    protected QuestionForReviewDto questionToQuestionForReviewDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionForReviewDto questionForReviewDto = new QuestionForReviewDto();

        questionForReviewDto.setId( question.getId() );
        questionForReviewDto.setQuestionEnglish( question.getQuestionEnglish() );
        questionForReviewDto.setQuestionFrench( question.getQuestionFrench() );
        if ( question.getMarks() != null ) {
            questionForReviewDto.setMarks( question.getMarks().intValue() );
        }

        return questionForReviewDto;
    }

    private String questionnaireQuestionQuestionSkillName(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }
        Question question = questionnaireQuestion.getQuestion();
        if ( question == null ) {
            return null;
        }
        Skill skill = question.getSkill();
        if ( skill == null ) {
            return null;
        }
        String name = skill.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String questionnaireQuestionQuestionQuestionEnglish(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }
        Question question = questionnaireQuestion.getQuestion();
        if ( question == null ) {
            return null;
        }
        String questionEnglish = question.getQuestionEnglish();
        if ( questionEnglish == null ) {
            return null;
        }
        return questionEnglish;
    }

    private Double questionnaireQuestionQuestionMarks(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }
        Question question = questionnaireQuestion.getQuestion();
        if ( question == null ) {
            return null;
        }
        Double marks = question.getMarks();
        if ( marks == null ) {
            return null;
        }
        return marks;
    }

    private QuestionTypeEnum questionnaireQuestionQuestionType(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }
        Question question = questionnaireQuestion.getQuestion();
        if ( question == null ) {
            return null;
        }
        QuestionTypeEnum type = question.getType();
        if ( type == null ) {
            return null;
        }
        return type;
    }

    private SkillLevelEnum questionnaireQuestionQuestionSkillLevel(QuestionnaireQuestion questionnaireQuestion) {
        if ( questionnaireQuestion == null ) {
            return null;
        }
        Question question = questionnaireQuestion.getQuestion();
        if ( question == null ) {
            return null;
        }
        SkillLevelEnum skillLevel = question.getSkillLevel();
        if ( skillLevel == null ) {
            return null;
        }
        return skillLevel;
    }
}
