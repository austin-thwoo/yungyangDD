package com.austin.yungyangdd.domain.ingredient.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_INGREDIENT_SYMPTOMS")
public class IngredientSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;
    @ManyToOne(fetch = FetchType.LAZY)
    private Symptom symptom;

    public static IngredientSymptom create(Ingredient ingredient, Symptom symptom) {
        return IngredientSymptom.builder()
                .ingredient(ingredient)
                .symptom(symptom)
                .build();
    }

    public IngredientSymptom addOTM() {
        this.ingredient.addThis(this);
        this.symptom.addThis(this);
        return this;
    }
}
