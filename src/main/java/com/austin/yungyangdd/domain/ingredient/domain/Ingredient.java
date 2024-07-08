package com.austin.yungyangdd.domain.ingredient.domain;

import com.austin.yungyangdd.domain.ingredient.dto.request.IngredientSaveCommand;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Nutrient> nutrients = new ArrayList<>();

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<IngredientSymptom> ingredientSymptom = new ArrayList<>();

    public static Ingredient create(String name) {
        return Ingredient.builder()
                .name(name)
                .build();
    }


    public void addNutrient(Nutrient nutrient) {
        this.nutrients.add(nutrient);
    }

    public void addThis(IngredientSymptom ingredientSymptom ) {
       this.ingredientSymptom.add(ingredientSymptom);
    }
}
