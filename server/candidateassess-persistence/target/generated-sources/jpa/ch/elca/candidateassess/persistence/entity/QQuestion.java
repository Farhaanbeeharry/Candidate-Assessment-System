package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = -577802533L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestion question = new QQuestion("question");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Double> marks = createNumber("marks", Double.class);

    public final StringPath questionEnglish = createString("questionEnglish");

    public final StringPath questionEnglishFiltered = createString("questionEnglishFiltered");

    public final StringPath questionFrench = createString("questionFrench");

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.QuestionStatusEnum> questionStatus = createEnum("questionStatus", ch.elca.candidateassess.persistence.enumeration.QuestionStatusEnum.class);

    public final QSkill skill;

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum> skillLevel = createEnum("skillLevel", ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum.class);

    public final NumberPath<Integer> timeAssignedForQuestion = createNumber("timeAssignedForQuestion", Integer.class);

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.QuestionTypeEnum> type = createEnum("type", ch.elca.candidateassess.persistence.enumeration.QuestionTypeEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QQuestion(String variable) {
        this(Question.class, forVariable(variable), INITS);
    }

    public QQuestion(Path<? extends Question> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestion(PathMetadata metadata, PathInits inits) {
        this(Question.class, metadata, inits);
    }

    public QQuestion(Class<? extends Question> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.skill = inits.isInitialized("skill") ? new QSkill(forProperty("skill")) : null;
    }

}

