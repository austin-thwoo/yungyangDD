package com.austin.yungyangdd.domain.supplements.api;

import com.austin.yungyangdd.domain.supplements.dto.request.ShopSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.response.ShopResponse;
import com.austin.yungyangdd.domain.supplements.dto.response.SupplementResponse;
import com.austin.yungyangdd.domain.supplements.service.ShopService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.global.dto.response.ApiListResponse;
import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Api(value = "판매처")
@RequestMapping("/shop")
public class ShopApi {

    private final ShopService shopService;


    @ApiOperation(value = "매장보기")
    @GetMapping("/{shopId}")
    public ApiResponse<ShopResponse> findById(@PathVariable(name = "shopId") Long shopId,
                                              @RequestParam String query) {
        return new ApiResponse<>(shopService.findByShopId(shopId,query));
    }
    @ApiOperation(value = "내 나이대 추천")
    @GetMapping("recommend-me")
    public ApiListResponse<SupplementResponse> recommendByMe(@AuthenticationPrincipal User principal) {
        return new ApiListResponse<>(shopService.recommendByMe(principal));
    }

    @ApiOperation(value = "선택 나이대 추천")
    @GetMapping("/recommend-age")
    public ApiListResponse<SupplementResponse> recommendByAge(@AuthenticationPrincipal User principal,
                                                              @RequestParam(name = "age") Long age) {
        return new ApiListResponse<>(shopService.recommendByAge(age));
    }
    @ApiOperation(value = "영양제 상세보기")
    @GetMapping("/supplement/{supplemenetId}")
    public ApiResponse<SupplementResponse> findById(@AuthenticationPrincipal User principal,
                                                              @PathVariable(name = "supplemenetId") Long supplemenetId) {
        return new ApiResponse<>(shopService.findSupplementById(supplemenetId));
    }





}
