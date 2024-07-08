package com.austin.yungyangdd.domain.supplements.domain;


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
@Table(name = "T_SALE_SHOP")
public class SaleShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplements supplements;

    private Long price;

    public static SaleShop create(Supplements supplements, Shop shop,Long price) {
        return SaleShop.builder()
                .shop(shop)
                .supplements(supplements)
                .price(price)
                .build();

    }
}
