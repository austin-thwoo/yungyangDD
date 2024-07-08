package com.austin.yungyangdd.domain.ingredient.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIngredientSymptom is a Querydsl query type for IngredientSymptom
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIngredientSymptom extends EntityPathBase<IngredientSymptom> {

    private static final long serialVersionUID = -461078190L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIngredientSymptom ingredientSymptom = new QIngredientSymptom("ingredientSymptom");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QIngredient ingredient;

    public final QSymptom symptom;

    public QIngredientSymptom(String variable) {
        this(IngredientSymptom.class, forVariable(variable), INITS);
    }

    public QIngredientSymptom(Path<? extends IngredientSymptom> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIngredientSymptom(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIngredientSymptom(PathMetadata metadata, PathInits inits) {
        this(IngredientSymptom.class, metadata, inits);
    }

    public QIngredientSymptom(Class<? extends IngredientSymptom> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingredient = inits.isInitialized("ingredient") ? new QIngredient(forProperty("ingredient")) : null;
        this.symptom = inits.isInitialized("symptom") ? new QSymptom(forProperty("symptom")) : null;
    }

}

