package com.austin.yungyangdd.domain.ingredient.repository;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.ingredient.domain.Symptom;
import com.austin.yungyangdd.domain.ingredient.exception.IngredientNotFoundException;
import com.austin.yungyangdd.domain.ingredient.exception.SymptomNotFoundException;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
//import static com.austin.yungyangdd.domain.ingredient.domain.QIngredientSymptom.ingredientSymptom;
import java.util.List;

import static com.austin.yungyangdd.domain.ingredient.domain.QSymptom.symptom;
import static com.austin.yungyangdd.domain.ingredient.domain.QIngredient.ingredient;


@Repository
public class IngredientRepositorySupport extends QuerydslRepositorySupport {
    private JPAQueryFactory queryFactory;


    public IngredientRepositorySupport(JPAQueryFactory queryFactory) {
        super(Ingredient.class);
        this.queryFactory = queryFactory;
    }

    public Page<Symptom> findAllPage(Pageable pageable, String symptomQuery) {
        QueryResults<Symptom> result = queryFactory.selectFrom(symptom)
                .where(symptom.id.isNotNull()
                        .and(symptomQuery(symptomQuery)))
                .orderBy(symptom.symptoms.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    }

    private BooleanExpression symptomQuery(String symptomQuery) {
        if (symptomQuery == null) {
            return null;
        }
        return symptom.symptoms.contains(symptomQuery);

    }

    public Symptom findSymptomById(Long symptomId) {
        Symptom result = queryFactory.selectFrom(symptom)
                .where(symptom.id.eq(symptomId)).fetchOne();

        if (result == null) {
            throw new SymptomNotFoundException(symptomId.toString());
        }
        return result;
    }

    public List<Symptom> findSymptomsByIds(List<Long> symptomIds) {
        return queryFactory.selectFrom(symptom)
                .where(symptom.id.in(symptomIds))
                .fetch();


    }

    public Ingredient findById(Long ingredientId) {
         Ingredient result=queryFactory.selectFrom(ingredient).where(ingredient.id.eq(ingredientId)).fetchOne();
         if (result==null){
             throw new IngredientNotFoundException(ingredientId.toString());

         }
         return result;
    }

//
//    public Shop findShopById(Long shopId) {
//        Shop result = queryFactory.selectFrom(shop)
//                .where(shop.id.eq(shopId)).fetchOne();
//        if (result == null) {
//            throw new ShopNotFoundException(shopId.toString());
//        }
//        return result;
//    }


}
