package com.austin.yungyangdd.domain.supplements.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShop is a Querydsl query type for Shop
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShop extends EntityPathBase<Shop> {

    private static final long serialVersionUID = -1240229133L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShop shop = new QShop("shop");

    public final com.austin.yungyangdd.domain.common.models.QAddress address;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.austin.yungyangdd.domain.user.domain.QUser master;

    public final StringPath name = createString("name");

    public final ListPath<SaleShop, QSaleShop> saleShop = this.<SaleShop, QSaleShop>createList("saleShop", SaleShop.class, QSaleShop.class, PathInits.DIRECT2);

    public final StringPath tel = createString("tel");

    public final EnumPath<com.austin.yungyangdd.domain.supplements.domain.type.ShopType> type = createEnum("type", com.austin.yungyangdd.domain.supplements.domain.type.ShopType.class);

    public QShop(String variable) {
        this(Shop.class, forVariable(variable), INITS);
    }

    public QShop(Path<? extends Shop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShop(PathMetadata metadata, PathInits inits) {
        this(Shop.class, metadata, inits);
    }

    public QShop(Class<? extends Shop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.austin.yungyangdd.domain.common.models.QAddress(forProperty("address")) : null;
        this.master = inits.isInitialized("master") ? new com.austin.yungyangdd.domain.user.domain.QUser(forProperty("master"), inits.get("master")) : null;
    }

}

