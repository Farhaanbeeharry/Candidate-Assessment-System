package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPosition is a Querydsl query type for Position
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPosition extends EntityPathBase<Position> {

    private static final long serialVersionUID = 1335872542L;

    public static final QPosition position = new QPosition("position1");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QPosition(String variable) {
        super(Position.class, forVariable(variable));
    }

    public QPosition(Path<? extends Position> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPosition(PathMetadata metadata) {
        super(Position.class, metadata);
    }

}

