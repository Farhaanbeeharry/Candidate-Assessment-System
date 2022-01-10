package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserQuestionnaireSkill is a Querydsl query type for UserQuestionnaireSkill
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserQuestionnaireSkill extends EntityPathBase<UserQuestionnaireSkill> {

    private static final long serialVersionUID = 663005134L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserQuestionnaireSkill userQuestionnaireSkill = new QUserQuestionnaireSkill("userQuestionnaireSkill");

    public final QAuditModel _super = new QAuditModel(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum> level = createEnum("level", ch.elca.candidateassess.persistence.enumeration.SkillLevelEnum.class);

    public final QSkill skill;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public final QUserQuestionnaire userQuestionnaire;

    public QUserQuestionnaireSkill(String variable) {
        this(UserQuestionnaireSkill.class, forVariable(variable), INITS);
    }

    public QUserQuestionnaireSkill(Path<? extends UserQuestionnaireSkill> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserQuestionnaireSkill(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserQuestionnaireSkill(PathMetadata metadata, PathInits inits) {
        this(UserQuestionnaireSkill.class, metadata, inits);
    }

    public QUserQuestionnaireSkill(Class<? extends UserQuestionnaireSkill> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.skill = inits.isInitialized("skill") ? new QSkill(forProperty("skill")) : null;
        this.userQuestionnaire = inits.isInitialized("userQuestionnaire") ? new QUserQuestionnaire(forProperty("userQuestionnaire"), inits.get("userQuestionnaire")) : null;
    }

}

