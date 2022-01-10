package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCandidateAnswer is a Querydsl query type for CandidateAnswer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCandidateAnswer extends EntityPathBase<CandidateAnswer> {

    private static final long serialVersionUID = 245617292L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCandidateAnswer candidateAnswer = new QCandidateAnswer("candidateAnswer");

    public final QAuditModel _super = new QAuditModel(this);

    public final QAnswer answer;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Double> marksAllocated = createNumber("marksAllocated", Double.class);

    public final QQuestion question;

    public final StringPath textAnswer = createString("textAnswer");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public final QUserQuestionnaire userQuestionnaire;

    public QCandidateAnswer(String variable) {
        this(CandidateAnswer.class, forVariable(variable), INITS);
    }

    public QCandidateAnswer(Path<? extends CandidateAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCandidateAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCandidateAnswer(PathMetadata metadata, PathInits inits) {
        this(CandidateAnswer.class, metadata, inits);
    }

    public QCandidateAnswer(Class<? extends CandidateAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.answer = inits.isInitialized("answer") ? new QAnswer(forProperty("answer"), inits.get("answer")) : null;
        this.question = inits.isInitialized("question") ? new QQuestion(forProperty("question"), inits.get("question")) : null;
        this.userQuestionnaire = inits.isInitialized("userQuestionnaire") ? new QUserQuestionnaire(forProperty("userQuestionnaire"), inits.get("userQuestionnaire")) : null;
    }

}

