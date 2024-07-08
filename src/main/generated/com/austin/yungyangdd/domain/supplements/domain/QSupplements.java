package com.austin.yungyangdd.domain.supplements.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSupplements is a Querydsl query type for Supplements
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplements extends EntityPathBase<Supplements> {

    private static final long serialVersionUID = -302909379L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSupplements supplements = new QSupplements("supplements");

    public final com.austin.yungyangdd.domain.common.models.QAgeCount ageCount;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QManufacturer manufacturer;

    public final StringPath name = createString("name");

    public final ListPath<com.austin.yungyangdd.domain.nutrient.domain.Nutrient, com.austin.yungyangdd.domain.nutrient.domain.QNutrient> nutrients = this.<com.austin.yungyangdd.domain.nutrient.domain.Nutrient, com.austin.yungyangdd.domain.nutrient.domain.QNutrient>createList("nutrients", com.austin.yungyangdd.domain.nutrient.domain.Nutrient.class, com.austin.yungyangdd.domain.nutrient.domain.QNutrient.class, PathInits.DIRECT2);

    public final NumberPath<Long> recommendAge = createNumber("recommendAge", Long.class);

    public final ListPath<SaleShop, QSaleShop> saleShop = this.<SaleShop, QSaleShop>createList("saleShop", SaleShop.class, QSaleShop.class, PathInits.DIRECT2);

    public final StringPath secondName = createString("secondName");

    public QSupplements(String variable) {
        this(Supplements.class, forVariable(variable), INITS);
    }

    public QSupplements(Path<? extends Supplements> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSupplements(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSupplements(PathMetadata metadata, PathInits inits) {
        this(Supplements.class, metadata, inits);
    }

    public QSupplements(Class<? extends Supplements> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ageCount = inits.isInitialized("ageCount") ? new com.austin.yungyangdd.domain.common.models.QAgeCount(forProperty("ageCount")) : null;
        this.manufacturer = inits.isInitialized("manufacturer") ? new QManufacturer(forProperty("manufacturer"), inits.get("manufacturer")) : null;
    }

}

