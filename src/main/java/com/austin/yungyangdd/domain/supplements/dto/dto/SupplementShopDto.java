package com.austin.yungyangdd.domain.supplements.dto.dto;

import com.austin.yungyangdd.domain.supplements.domain.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SupplementShopDto {

    private Long shopId;
    private Long price;
    private Shop shop;

    public void setShop(Shop shop){
        this.shop=shop;

    }
}
