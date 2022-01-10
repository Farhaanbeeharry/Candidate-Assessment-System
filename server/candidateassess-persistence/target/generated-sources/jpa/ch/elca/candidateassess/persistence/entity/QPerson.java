package ch.elca.candidateassess.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -669317238L;

    public static final QPerson person = new QPerson("person");

    public final QAuditModel _super = new QAuditModel(this);

    public final EnumPath<ch.elca.candidateassess.persistence.enumeration.AccountTypeEnum> accountType = createEnum("accountType", ch.elca.candidateassess.persistence.enumeration.AccountTypeEnum.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdOn = _super.createdOn;

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstName = createString("firstName");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedOn = _super.updatedOn;

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

