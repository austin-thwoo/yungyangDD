package com.austin.yungyangdd.domain.supplements.dto.request;

import com.austin.yungyangdd.domain.supplements.dto.dto.SaleShopDto;
import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementShopDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class SaleShopCommand {
    private Long shopId;
    private List<SaleShopDto> saleShopDtos;

}
