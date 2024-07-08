package com.austin.yungyangdd.domain.supplements.api;

import com.austin.yungyangdd.domain.supplements.dto.request.SaleShopCommand;
import com.austin.yungyangdd.domain.supplements.dto.request.ShopSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.request.SupplementSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.response.ShopResponse;
import com.austin.yungyangdd.domain.supplements.dto.response.SupplementResponse;
import com.austin.yungyangdd.domain.supplements.service.ShopManageService;
import com.austin.yungyangdd.domain.supplements.service.ShopService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(value = "판매처")
@RequestMapping("/agent/shop")
public class ShopManageApi {

    private final ShopManageService shopManageService;


    @ApiOperation(value = "register")
    @PostMapping
    public ApiResponse<ShopResponse> save(@AuthenticationPrincipal User principal,
            @RequestBody ShopSaveCommand saveCommand) {
        return new ApiResponse<>(shopManageService.register(principal, saveCommand));
    }

    @ApiOperation(value = "매장에 영양제 항목추가")
    @PostMapping("/supplement")
    public ApiResponse<ShopResponse> save(@AuthenticationPrincipal User principal,
                                                @RequestBody SaleShopCommand saleShopCommand
                                                ) {
        return new ApiResponse<>(shopManageService.addSupplement(principal, saleShopCommand));
    }



}
