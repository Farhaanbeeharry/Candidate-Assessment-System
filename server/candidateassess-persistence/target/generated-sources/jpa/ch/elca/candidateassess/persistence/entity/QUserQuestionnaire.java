package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserQuestionnaire is a Querydsl query type for UserQuestionnaire
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserQuestionnaire extends EntityPathBase<UserQuestionnaire> {

    private static final long serialVersionUID = 1265787971L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserQuestionnaire userQuestionnaire = new QUserQuestionnaire("userQuestionnaire");

    public final QAuditModel _super = new QAuditModel(this);

    public final BooleanPath autoGenerate = createBoolean("autoGenerate");

    public final BooleanPath candidateSelectSkills = createBoolean("candidateSelectSkills");

    public final NumberPath<Integer> cheatCount = createNumber("cheatCount", Integer.class);

    public final StringPath comment = createString("comment");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstName = createString("firstName");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final DateTimePath<java.time.LocalDateTime> interviewDate = createDateTime("interviewDate", java.time.LocalDateTime.class);

    public final BooleanPath isAttempted = createBoolean("isAttempted");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Double> marks = createNumber("marks", Double.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QPosition position;

    public final QQuestionnaire questionnaire;

    public final NumberPath<Integer> remainingTime = createNumber("remainingTime", Integer.class);

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.QuestionnaireStatusEnum> status = createEnum("status", ch.elca.candidateassess.persistence.enumeration.QuestionnaireStatusEnum.class);

    public final NumberPath<Integer> timeTakenToCompleteQuestionnaire = createNumber("timeTakenToCompleteQuestionnaire", Integer.class);

    public final StringPath token = createString("token");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public final BooleanPath userArchived = createBoolean("userArchived");

    public QUserQuestionnaire(String variable) {
        this(UserQuestionnaire.class, forVariable(variable), INITS);
    }

    public QUserQuestionnaire(Path<? extends UserQuestionnaire> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserQuestionnaire(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserQuestionnaire(PathMetadata metadata, PathInits inits) {
        this(UserQuestionnaire.class, metadata, inits);
    }

    public QUserQuestionnaire(Class<? extends UserQuestionnaire> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.position = inits.isInitialized("position") ? new QPosition(forProperty("position")) : null;
        this.questionnaire = inits.isInitialized("questionnaire") ? new QQuestionnaire(forProperty("questionnaire")) : null;
    }

}

