package com.austin.yungyangdd.domain.ingredient.domain;

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
@Table(name = "T_SYMPTOM")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symptoms;


    @OneToMany(mappedBy = "symptom", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<IngredientSymptom> ingredientSymptoms= new ArrayList<>();

    public static Symptom create(String symptom) {
        return Symptom.builder()
                .symptoms(symptom)
                .build();
    }

    public Boolean modify(String symptomContent) {
        this.symptoms=symptomContent;
        return true;
    }

    public void addThis(IngredientSymptom ingredientSymptom) {
        this.ingredientSymptoms.add(ingredientSymptom);
    }
}
