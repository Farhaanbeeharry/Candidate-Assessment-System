package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionnaireQuestion is a Querydsl query type for QuestionnaireQuestion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuestionnaireQuestion extends EntityPathBase<QuestionnaireQuestion> {

    private static final long serialVersionUID = -425108012L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionnaireQuestion questionnaireQuestion = new QQuestionnaireQuestion("questionnaireQuestion");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final QQuestion question;

    public final QQuestionnaire questionnaire;

    public final NumberPath<Integer> questionNumber = createNumber("questionNumber", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QQuestionnaireQuestion(String variable) {
        this(QuestionnaireQuestion.class, forVariable(variable), INITS);
    }

    public QQuestionnaireQuestion(Path<? extends QuestionnaireQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionnaireQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionnaireQuestion(PathMetadata metadata, PathInits inits) {
        this(QuestionnaireQuestion.class, metadata, inits);
    }

    public QQuestionnaireQuestion(Class<? extends QuestionnaireQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
        this.questionnaire = inits.isInitialized("questionnaire") ? new QQuestionnaire(forProperty("questionnaire")) : null;
    }

}

