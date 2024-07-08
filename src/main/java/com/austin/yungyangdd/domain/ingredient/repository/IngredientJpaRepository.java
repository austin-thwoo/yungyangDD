package com.austin.yungyangdd.domain.ingredient.repository;

import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientJpaRepository extends JpaRepository<Ingredient,Long> {
}
