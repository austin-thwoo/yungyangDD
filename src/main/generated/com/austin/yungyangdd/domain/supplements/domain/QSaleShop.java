package com.austin.yungyangdd.domain.supplements.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSaleShop is a Querydsl query type for SaleShop
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSaleShop extends EntityPathBase<SaleShop> {

    private static final long serialVersionUID = -2076635814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSaleShop saleShop = new QSaleShop("saleShop");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final QShop shop;

    public final QSupplements supplements;

    public QSaleShop(String variable) {
        this(SaleShop.class, forVariable(variable), INITS);
    }

    public QSaleShop(Path<? extends SaleShop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSaleShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSaleShop(PathMetadata metadata, PathInits inits) {
        this(SaleShop.class, metadata, inits);
    }

    public QSaleShop(Class<? extends SaleShop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop"), inits.get("shop")) : null;
        this.supplements = inits.isInitialized("supplements") ? new QSupplements(forProperty("supplements"), inits.get("supplements")) : null;
    }

}

