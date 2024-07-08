package com.austin.yungyangdd.domain.supplements.domain;


import com.austin.yungyangdd.domain.common.models.AgeCount;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import com.austin.yungyangdd.domain.supplements.dto.request.SupplementSaveCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_SUPPLEMENTS")
public class Supplements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String secondName;

    private Long recommendAge;

    @Embedded
    private AgeCount ageCount;


    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "supplements", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<SaleShop> saleShop = new ArrayList<>();

    @OneToMany(mappedBy = "supplements", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Nutrient> nutrients = new ArrayList<>();


    public static Supplements create(SupplementSaveCommand saveCommand, Manufacturer manufacturer) {
        return Supplements.builder()
                .name(saveCommand.getName())
                .secondName(saveCommand.getSecondName())
                .recommendAge(saveCommand.getRecommendAge())
                .manufacturer(manufacturer)
                .build();
    }

    public void addSaleShop(SaleShop saleShop) {
        this.saleShop.add(saleShop);
    }

    public void addNutrient(Nutrient nutrient) {
        this.nutrients.add(nutrient);
    }
}

