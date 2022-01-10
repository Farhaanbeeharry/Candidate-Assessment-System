package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateQuestionDto;
import ch.elca.candidateassess.dto.EditQuestionDto;
import ch.elca.candidateassess.dto.NewQuestionDto;
import ch.elca.candidateassess.dto.QuestionDto;
import ch.elca.candidateassess.dto.ViewQuestionDto;
import ch.elca.candidateassess.persistence.entity.Question;
import ch.elca.candidateassess.persistence.entity.Skill;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public Question mapToQuestion(CreateQuestionDto createQuestionDto) {
        if ( createQuestionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setQuestionEnglish( createQuestionDto.getQuestionEnglish() );
        question.setQuestionFrench( createQuestionDto.getQuestionFrench() );
        question.setQuestionStatus( createQuestionDto.getQuestionStatus() );
        question.setType( createQuestionDto.getType() );
        question.setMarks( createQuestionDto.getMarks() );
        question.setTimeAssignedForQuestion( createQuestionDto.getTimeAssignedForQuestion() );
        question.setSkillLevel( createQuestionDto.getSkillLevel() );

        return question;
    }

    @Override
    public Question mapToQuestionFromEditQuestionDto(EditQuestionDto editQuestionDto) {
        if ( editQuestionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setTimeAssignedForQuestion( editQuestionDto.getTime() );
        question.setType( editQuestionDto.getQuestionType() );
        question.setSkillLevel( editQuestionDto.getLevel() );
        question.setId( editQuestionDto.getId() );
        question.setQuestionEnglish( editQuestionDto.getQuestionEnglish() );
        question.setMarks( editQuestionDto.getMarks() );
        question.setSkill( editQuestionDto.getSkill() );

        return question;
    }

    @Override
    public Question mapToNewQuestion(NewQuestionDto newQuestionDto) {
        if ( newQuestionDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setSkill( newQuestionDtoToSkill( newQuestionDto ) );
        question.setTimeAssignedForQuestion( newQuestionDto.getTime() );
        question.setType( newQuestionDto.getQuestionType() );
        question.setSkillLevel( newQuestionDto.getLevel() );
        question.setId( newQuestionDto.getId() );
        question.setQuestionEnglish( newQuestionDto.getQuestionEnglish() );
        question.setQuestionFrench( newQuestionDto.getQuestionFrench() );
        question.setMarks( newQuestionDto.getMarks() );

        return question;
    }

    @Override
    public EditQuestionDto mapToEditQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        EditQuestionDto editQuestionDto = new EditQuestionDto();

        editQuestionDto.setTime( question.getTimeAssignedForQuestion() );
        editQuestionDto.setLevel( question.getSkillLevel() );
        editQuestionDto.setQuestionType( question.getType() );
        editQuestionDto.setId( question.getId() );
        editQuestionDto.setQuestionEnglish( question.getQuestionEnglish() );
        editQuestionDto.setSkill( question.getSkill() );
        editQuestionDto.setMarks( question.getMarks() );

        return editQuestionDto;
    }

    @Override
    public QuestionDto mapToQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setId( question.getId() );
        questionDto.setQuestionEnglish( question.getQuestionEnglish() );
        questionDto.setQuestionFrench( question.getQuestionFrench() );
        questionDto.setType( question.getType() );
        questionDto.setMarks( question.getMarks() );

        return questionDto;
    }

    @Override
    public ViewQuestionDto mapToViewQuestionDto(Question question) {
        if ( question == null ) {
            return null;
        }

        ViewQuestionDto viewQuestionDto = new ViewQuestionDto();

        viewQuestionDto.setTime( question.getTimeAssignedForQuestion() );
        viewQuestionDto.setLevel( question.getSkillLevel() );
        viewQuestionDto.setQuestionType( question.getType() );
        viewQuestionDto.setId( question.getId() );
        viewQuestionDto.setQuestionEnglish( question.getQuestionEnglish() );
        viewQuestionDto.setSkill( question.getSkill() );
        viewQuestionDto.setMarks( question.getMarks() );

        return viewQuestionDto;
    }

    protected Skill newQuestionDtoToSkill(NewQuestionDto newQuestionDto) {
        if ( newQuestionDto == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setId( newQuestionDto.getSkillId() );

        return skill;
    }
}
