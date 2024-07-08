package com.austin.yungyangdd.domain.supplements.service;

import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.ingredient.exception.IngredientNotMatchException;
import com.austin.yungyangdd.domain.ingredient.repository.IngredientJpaRepository;
import com.austin.yungyangdd.domain.nutrient.domain.Nutrient;
import com.austin.yungyangdd.domain.supplements.domain.Manufacturer;
import com.austin.yungyangdd.domain.supplements.domain.SaleShop;
import com.austin.yungyangdd.domain.supplements.domain.Shop;
import com.austin.yungyangdd.domain.supplements.domain.Supplements;
import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementShopDto;
import com.austin.yungyangdd.domain.supplements.dto.dto.SupplementingredientDto;
import com.austin.yungyangdd.domain.supplements.dto.request.ManufacturerSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.request.SupplementSaveCommand;
import com.austin.yungyangdd.domain.supplements.dto.response.ManufacturerReponse;
import com.austin.yungyangdd.domain.supplements.dto.response.SupplementResponse;
import com.austin.yungyangdd.domain.supplements.exception.ManufacturerOverlapException;
import com.austin.yungyangdd.domain.supplements.repository.*;
import com.austin.yungyangdd.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SupplementCommandService {


    private final SupplementsRepositorySupport supplementsRepositorySupport;
    private final SupplementsJpaRepository supplementsJpaRepository;
    private final SaleShopJpaRepository saleShopJpaRepository;
    private final ShopJpaRepository shopJpaRepository;
    private final NutrientJpaRepository nutrientJpaRepository;
    private final IngredientJpaRepository ingredientJpaRepository;
    private final ManufacturerJpaRepository manufacturerJpaRepository;
    public SupplementResponse register(SupplementSaveCommand saveCommand) {

        Supplements supplements = supplementsPlace(saveCommand);

        return new SupplementResponse(supplements);
    }

    private Supplements supplementsPlace(SupplementSaveCommand saveCommand) {

        Manufacturer manufacturer = findManufacturerById(saveCommand.getManufacturerId());
        Supplements supplements = supplementsCreate(saveCommand, manufacturer);
        saleShopCreate(supplements, saveCommand.getShopDtos());
        nutrientCreate(supplements, saveCommand.getIngredientDtos());
        return supplements;
    }

    private void nutrientCreate(Supplements supplements, List<SupplementingredientDto> dtos) {

        for (SupplementingredientDto dto : dtos) {
            Nutrient nutrient = Nutrient.create(supplements, ingredientJpaRepository.findById(dto.getIngredientId()).get(), dto.getIngredientContent());
            nutrientJpaRepository.save(nutrient);
            nutrient.getIngredient().addNutrient(nutrient);
            supplements.addNutrient(nutrient);
        }
    }

    private void saleShopCreate(Supplements supplements, List<SupplementShopDto> dtos) {
//        List<HashMap<String ,HashMap<String, Long>>> s = new ArrayList<>();
        for (SupplementShopDto dto : dtos) {
            SaleShop saleShop = SaleShop.create(supplements, shopJpaRepository.findById(dto.getShopId()).get(), dto.getPrice());
            saleShopJpaRepository.save(saleShop);
            saleShop.getShop().addSaleShop(saleShop);
            supplements.addSaleShop(saleShop);
        }
    }

    private Supplements supplementsCreate(SupplementSaveCommand saveCommand, Manufacturer manufacturer) {
        Supplements supplements = Supplements.create(saveCommand, manufacturer);
        return supplementsJpaRepository.save(supplements);
    }

    private List<Ingredient> getNutrientList(List<Long> ingredientIds) {
        return supplementsRepositorySupport.findIngredientByIds(ingredientIds);
    }

    private List<Shop> getShopList(List<Long> saleShopId) {
        return supplementsRepositorySupport.findShopsByIds(saleShopId);
    }

    private Manufacturer findManufacturerById(Long manufacturerId) {
        return supplementsRepositorySupport.findManufacturerById(manufacturerId);
    }

    @Transactional
    public SupplementResponse updateSupplement(User principal, Long supplementId, List<SupplementingredientDto> SupplementingredientDtos) {

        Supplements supplements = getSupplementById(supplementId);
//        List<Ingredient> ingredients=getIngredientsByIds(SupplementingredientDtos);
        nutrientCreate(supplements, SupplementingredientDtos);
        return new SupplementResponse(supplements);


    }

    private List<Ingredient> getIngredientsByIds(List<Long> ingredientIds) {

        List<Ingredient> ingredientList = supplementsRepositorySupport.findIngredientByIds(ingredientIds);

        if (ingredientIds.size() == ingredientList.size()) {
            return ingredientList;

        }
        throw new IngredientNotMatchException("모든번호를 다 찾아오지 못했습니다.");
    }

    private Supplements getSupplementById(Long supplementId) {
        return supplementsRepositorySupport.findSupplementById(supplementId);
    }

    public ManufacturerReponse manuSave(ManufacturerSaveCommand saveCommand) {
        overlapCheck(saveCommand.getName());
        List<Supplements> supplementsList = getSupplementsByIds(saveCommand.getSupplementIds());
        Manufacturer manufacturer=Manufacturer.create(saveCommand);
        manufacturer.addSupplements(supplementsList);
        manufacturerJpaRepository.save(manufacturer);
        return new ManufacturerReponse(manufacturer);

    }

    private void overlapCheck(String name) {
        Optional<Manufacturer> manufacturer =manufacturerJpaRepository.findByName(name);
        if (manufacturer.isPresent()){
            throw new ManufacturerOverlapException(name);

        }
    }

    private List<Supplements> getSupplementsByIds(List<Long> supplementIds) {
        return supplementsRepositorySupport.findAllSupplementsByIds(supplementIds);
    }
}
