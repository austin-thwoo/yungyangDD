package com.austin.yungyangdd.domain.ingredient.api;

import com.austin.yungyangdd.domain.ingredient.dto.request.IngredientSaveCommand;
import com.austin.yungyangdd.domain.ingredient.dto.response.IngredientResponse;
import com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse.SymptomResponse;
import com.austin.yungyangdd.domain.ingredient.service.IngredientService;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.global.dto.response.ApiPagingResponse;
import com.austin.yungyangdd.global.dto.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "영양성분")
@RequestMapping("/ingredient")
public class IngredientApi {

    private final IngredientService ingredientService;


    @ApiOperation(value = "/symptomSave")
    @PostMapping("/symptom")
    public ApiResponse<?> symptomSave(@RequestBody String symptom) {
        return new ApiResponse<>(ingredientService.symptomRegister(symptom));
    }

    @ApiOperation(value = "")
    @GetMapping("/symptom")
    public ApiPagingResponse<SymptomResponse> symptomSave(@AuthenticationPrincipal User principal,
                                                          @RequestParam(name = "page",required = false,defaultValue = "1")int page,
                                                          @RequestParam(name = "query", required = false) String symptomQuery){
        return new ApiPagingResponse<>(ingredientService.getSymptomPage(principal,page,symptomQuery));
    }
    @ApiOperation(value = "symptomModify")
    @PatchMapping("/symptom/{symptomId}")
    public ApiResponse<Boolean> symptomModify(@AuthenticationPrincipal User principal,
                                                            @RequestParam String symptom,
                                                            @PathVariable(name = "symptomId")Long symptomId){
        return new ApiResponse<>(ingredientService.symptomModify(principal,symptom,symptomId));
    }
    @ApiOperation(value = "symptomDelete")
    @DeleteMapping("/symptom/{symptomId}")
    public ApiResponse<Boolean> symptomModify(@AuthenticationPrincipal User principal,
                                              @PathVariable(name = "symptomId")Long symptomId){
        return new ApiResponse<>(ingredientService.symptomDelete(principal,symptomId));
    }



    @ApiOperation(value = "IngredientSave")
    @PostMapping
    public ApiResponse<Boolean> ingredientSave(@AuthenticationPrincipal User user,
                                               @RequestBody IngredientSaveCommand saveCommand){
        return new ApiResponse<>(ingredientService.ingredientRegister(user,saveCommand));
    }

    @ApiOperation(value = "Ingredient connect to symptom")
    @GetMapping("/{ingredientId}")
    public ApiResponse<IngredientResponse> ingredientSave(@AuthenticationPrincipal User user,
                                                          @PathVariable(name = "ingredientId")Long ingredientId,
                                                          @RequestParam List<Long> symptomIds){
        return new ApiResponse<>(ingredientService.ingredientConnectSymptom(user,ingredientId,symptomIds));
    }





}
