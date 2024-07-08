package com.austin.yungyangdd.domain.ingredient.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIngredient is a Querydsl query type for Ingredient
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIngredient extends EntityPathBase<Ingredient> {

    private static final long serialVersionUID = -1634601769L;

    public static final QIngredient ingredient = new QIngredient("ingredient");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<IngredientSymptom, QIngredientSymptom> ingredientSymptom = this.<IngredientSymptom, QIngredientSymptom>createList("ingredientSymptom", IngredientSymptom.class, QIngredientSymptom.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<com.austin.yungyangdd.domain.nutrient.domain.Nutrient, com.austin.yungyangdd.domain.nutrient.domain.QNutrient> nutrients = this.<com.austin.yungyangdd.domain.nutrient.domain.Nutrient, com.austin.yungyangdd.domain.nutrient.domain.QNutrient>createList("nutrients", com.austin.yungyangdd.domain.nutrient.domain.Nutrient.class, com.austin.yungyangdd.domain.nutrient.domain.QNutrient.class, PathInits.DIRECT2);

    public QIngredient(String variable) {
        super(Ingredient.class, forVariable(variable));
    }

    public QIngredient(Path<? extends Ingredient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIngredient(PathMetadata metadata) {
        super(Ingredient.class, metadata);
    }

}

