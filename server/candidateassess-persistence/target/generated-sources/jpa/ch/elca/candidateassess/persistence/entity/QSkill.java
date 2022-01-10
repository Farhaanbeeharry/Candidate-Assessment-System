package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSkill is a Querydsl query type for Skill
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSkill extends EntityPathBase<Skill> {

    private static final long serialVersionUID = -1958313092L;

    public static final QSkill skill = new QSkill("skill");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QSkill(String variable) {
        super(Skill.class, forVariable(variable));
    }

    public QSkill(Path<? extends Skill> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSkill(PathMetadata metadata) {
        super(Skill.class, metadata);
    }

}

