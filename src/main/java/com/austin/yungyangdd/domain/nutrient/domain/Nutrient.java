package com.austin.yungyangdd.domain.nutrient.domain;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
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
@Table(name = "T_NUTRIENT")
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplements supplements;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    private Long content;//함량
//    TODO : 단위가 다르다면
//    @Enumerated(EnumType.STRING)
//    private Unit unit;


    public static Nutrient create(Supplements supplements, Ingredient ingredient, Long content) {
        return Nutrient.builder()
                .supplements(supplements)
                .ingredient(ingredient)
                .content(content)
                .build();
    }


}
