package com.austin.yungyangdd.domain.supplements.api;

import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementingredientDto;
import com.austin.yungyangdd.domain.supplements.dto.request.ManufacturerSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.request.SupplementSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.response.ManufacturerReponse;
import com.austin.yungyangdd.domain.supplements.dto.response.SupplementResponse;
import com.austin.yungyangdd.domain.supplements.service.SupplementCommandService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Api(value = "영양제")
@RequestMapping("/supplement")
public class SupplementApi {

    private final SupplementCommandService supplementCommandService;

    @ApiOperation(value = "영양제 등록")
    @PostMapping
    public ApiResponse<SupplementResponse> save(@RequestBody SupplementSaveCommand saveCommand) {
        return new ApiResponse<>(supplementCommandService.register(saveCommand));
    }

    @ApiOperation(value = "영양제 성분 수정")
    @PutMapping("/nutient/{supplementId}")
    public ApiResponse<SupplementResponse> updateSupplement(@AuthenticationPrincipal User principal,
                                                            @PathVariable(name = "supplementId") Long supplementId,
                                                            @RequestParam List<SupplementingredientDto> SupplementingredientDtos) {
        return new ApiResponse<>(supplementCommandService.updateSupplement(principal,supplementId,SupplementingredientDtos));
    }

    @ApiOperation(value = "manufacturer save")
    @PostMapping("/manufacturer")
    public ApiResponse<ManufacturerReponse> manufacturer(@RequestBody ManufacturerSaveCommand saveCommand) {
        return new ApiResponse<>(supplementCommandService.manuSave(saveCommand));
    }
}
