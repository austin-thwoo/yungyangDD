package com.austin.yungyangdd.domain.supplements.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QManufacturer is a Querydsl query type for Manufacturer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManufacturer extends EntityPathBase<Manufacturer> {

    private static final long serialVersionUID = -1443981618L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QManufacturer manufacturer = new QManufacturer("manufacturer");

    public final com.austin.yungyangdd.domain.common.models.QAddress address;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath owner = createString("owner");

    public final ListPath<Supplements, QSupplements> supplement = this.<Supplements, QSupplements>createList("supplement", Supplements.class, QSupplements.class, PathInits.DIRECT2);

    public final StringPath tel = createString("tel");

    public QManufacturer(String variable) {
        this(Manufacturer.class, forVariable(variable), INITS);
    }

    public QManufacturer(Path<? extends Manufacturer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QManufacturer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QManufacturer(PathMetadata metadata, PathInits inits) {
        this(Manufacturer.class, metadata, inits);
    }

    public QManufacturer(Class<? extends Manufacturer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.austin.yungyangdd.domain.common.models.QAddress(forProperty("address")) : null;
    }

}

