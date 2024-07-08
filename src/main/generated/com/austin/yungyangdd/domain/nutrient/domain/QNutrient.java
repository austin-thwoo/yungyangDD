package com.austin.yungyangdd.domain.nutrient.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNutrient is a Querydsl query type for Nutrient
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QNutrient extends EntityPathBase<Nutrient> {

    private static final long serialVersionUID = 281346243L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNutrient nutrient = new QNutrient("nutrient");

    public final NumberPath<Long> content = createNumber("content", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.austin.yungyangdd.domain.ingredient.domain.QIngredient ingredient;

    public final com.austin.yungyangdd.domain.supplements.domain.QSupplements supplements;

    public QNutrient(String variable) {
        this(Nutrient.class, forVariable(variable), INITS);
    }

    public QNutrient(Path<? extends Nutrient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNutrient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNutrient(PathMetadata metadata, PathInits inits) {
        this(Nutrient.class, metadata, inits);
    }

    public QNutrient(Class<? extends Nutrient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingredient = inits.isInitialized("ingredient") ? new com.austin.yungyangdd.domain.ingredient.domain.QIngredient(forProperty("ingredient")) : null;
        this.supplements = inits.isInitialized("supplements") ? new com.austin.yungyangdd.domain.supplements.domain.QSupplements(forProperty("supplements"), inits.get("supplements")) : null;
    }

}

