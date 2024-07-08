package com.austin.yungyangdd.domain.supplements.repository;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.exception.ManufacturerNotFoundException;
import com.austin.yungyangdd.domain.supplements.exception.ShopNotFoundException;
import com.austin.yungyangdd.domain.supplements.exception.SupplementNotFoundException;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.austin.yungyangdd.domain.supplements.domain.QShop.shop;
import static com.austin.yungyangdd.domain.ingredient.domain.QIngredient.ingredient;
import static com.austin.yungyangdd.domain.ingredient.domain.QIngredientSymptom.ingredientSymptom;
import static com.austin.yungyangdd.domain.ingredient.domain.QSymptom.symptom;
import static com.austin.yungyangdd.domain.nutrient.domain.QNutrient.nutrient;
import static com.austin.yungyangdd.domain.supplements.domain.QManufacturer.manufacturer;
import static com.austin.yungyangdd.domain.supplements.domain.QSupplements.supplements;

@Repository
public class SupplementsRepositorySupport extends QuerydslRepositorySupport {
    private JPAQueryFactory queryFactory;


    public SupplementsRepositorySupport(JPAQueryFactory queryFactory) {
        super(Supplements.class);
        this.queryFactory = queryFactory;
    }


    public Shop findShopById(Long shopId) {
        Shop result = queryFactory.selectFrom(shop)
                .where(shop.id.eq(shopId)).fetchOne();
        if (result == null) {
            throw new ShopNotFoundException(shopId.toString());
        }
        return result;
    }


    public List<Shop> findShopsByIds(List<Long> saleShopId) {
        return queryFactory.selectFrom(shop)
                .where(shop.id.in(saleShopId)).fetch();
    }

    public Manufacturer findManufacturerById(Long manufacturerId) {
        Manufacturer result = queryFactory.selectFrom(manufacturer)
                .where(manufacturer.id.eq(manufacturerId))
                .fetchOne();

        if (result == null) {
            throw new ManufacturerNotFoundException(manufacturerId.toString());
        }
        return result;

    }

    public List<Ingredient> findIngredientByIds(List<Long> ingredientIds) {
        return queryFactory.selectFrom(ingredient)
                .where(ingredient.id.in(ingredientIds)).fetch();

    }

    public Supplements findSupplementById(Long supplementId) {
        Supplements result=queryFactory.selectFrom(supplements)
                .where(supplements.id.eq(supplementId))
                .fetchOne();

        if (result ==null){
            throw new SupplementNotFoundException(supplementId.toString());
        }
        return result;
    }

    public List<Supplements> findAllSupplementsByIds(List<Long> supplementIds) {
        return queryFactory.selectFrom(supplements)
                .where(supplements.id.in(supplementIds)).fetch();
    }


    public List<Supplements> findAllSupplementsByAge(Long userAge) {
        return queryFactory.selectFrom(supplements)
                .where(supplements.recommendAge.eq(userAge))
                .fetch();
    }

    public List<Supplements> findAllSupplementsByQuery(String query) {
        return queryFactory.selectFrom(supplements)
                .leftJoin(nutrient).on(supplements.id.eq(nutrient.supplements.id))
                .leftJoin(ingredient).on(nutrient.id.eq(ingredient.id))
                .leftJoin(ingredientSymptom).on(ingredient.id.eq(ingredientSymptom.symptom.id))
                .leftJoin(symptom).on(ingredientSymptom.symptom.id.eq(symptom.id))
                .where(supplements.id.isNotNull()
                        .and(SupplementsNameQuery(query))
                        .and(supplementsIngredientQuery(query)))
                .fetch();
    }

    private BooleanExpression supplementsIngredientQuery(String query) {
        if (query==null){
            return null;}
        return nutrient.ingredient.name.contains(query);
    }

    private BooleanExpression SupplementsNameQuery(String query) {
        if (query==null||query.isBlank()){
            return null;
        }
        return supplements.name.contains(query);

    }
}
