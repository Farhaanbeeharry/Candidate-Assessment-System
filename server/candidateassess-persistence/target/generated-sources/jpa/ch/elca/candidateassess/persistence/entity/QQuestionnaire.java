package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionnaire is a Querydsl query type for Questionnaire
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQuestionnaire extends EntityPathBase<Questionnaire> {

    private static final long serialVersionUID = 1960209358L;

    public static final QQuestionnaire questionnaire = new QQuestionnaire("questionnaire");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final NumberPath<Double> marks = createNumber("marks", Double.class);

    public final StringPath templateName = createString("templateName");

    public final NumberPath<Integer> totalTime = createNumber("totalTime", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QQuestionnaire(String variable) {
        super(Questionnaire.class, forVariable(variable));
    }

    public QQuestionnaire(Path<? extends Questionnaire> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionnaire(PathMetadata metadata) {
        super(Questionnaire.class, metadata);
    }

}

