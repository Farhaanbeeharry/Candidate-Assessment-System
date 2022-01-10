package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswer is a Querydsl query type for Answer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnswer extends EntityPathBase<Answer> {

    private static final long serialVersionUID = -1090409485L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswer answer = new QAnswer("answer");

    public final QAuditModel _super = new QAuditModel(this);

    public final StringPath answerEnglish = createString("answerEnglish");

    public final StringPath answerFrench = createString("answerFrench");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final QQuestion question;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public final BooleanPath valid = createBoolean("valid");

    public QAnswer(String variable) {
        this(Answer.class, forVariable(variable), INITS);
    }

    public QAnswer(Path<? extends Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswer(PathMetadata metadata, PathInits inits) {
        this(Answer.class, metadata, inits);
    }

    public QAnswer(Class<? extends Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

