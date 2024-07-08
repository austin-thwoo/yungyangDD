package com.austin.yungyangdd.domain.ingredient.service;


import com.austin.yungyangdd.domain.ingredient.domain.Ingredient;
import com.austin.yungyangdd.domain.ingredient.domain.IngredientSymptom;
import com.austin.yungyangdd.domain.ingredient.domain.Symptom;
import com.austin.yungyangdd.domain.ingredient.dto.request.IngredientSaveCommand;
import com.austin.yungyangdd.domain.ingredient.dto.response.IngredientResponse;
import com.austin.yungyangdd.domain.ingredient.dto.response.simpleResponse.SymptomResponse;
import com.austin.yungyangdd.domain.ingredient.repository.IngredientJpaRepository;
import com.austin.yungyangdd.domain.ingredient.repository.IngredientRepositorySupport;
import com.austin.yungyangdd.domain.ingredient.repository.IngredientSymptomJpaRepository;
import com.austin.yungyangdd.domain.ingredient.repository.SymptomJpaRepository;
import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.global.dto.request.PageRequest;
import com.austin.yungyangdd.global.dto.response.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final SymptomJpaRepository symptomJpaRepository;
    private final IngredientJpaRepository ingredientJpaRepository;
    private final IngredientRepositorySupport ingredientRepositorySupport;
    private final IngredientSymptomJpaRepository ingredientSymptomJpaRepository;


    @Transactional
    public SymptomResponse symptomRegister(String symptom) {
        return new SymptomResponse(symptomJpaRepository.save(Symptom.create(symptom)));
    }

    public PagingResponse<SymptomResponse> getSymptomPage(User principal, int page, String symptomQuery) {

        PageRequest pageRequest = new PageRequest(page, 10);
        Page<Symptom> symptomsPage = ingredientRepositorySupport.findAllPage(pageRequest.of(), symptomQuery);

        return new PagingResponse<>(page, symptomsPage.getTotalPages(), symptomsPage.getTotalElements(),
                symptomsPage.getContent().stream().map(SymptomResponse::new).collect(Collectors.toList()));
    }

    @Transactional
    public Boolean symptomModify(User principal, String symptomContent, Long symptomId) {

        Symptom symptom = getSymptomById(symptomId);
        symptom.modify(symptomContent);
        return true;


    }

    private Symptom getSymptomById(Long symptomId) {
        return ingredientRepositorySupport.findSymptomById(symptomId);
    }

    @Transactional
    public Boolean symptomDelete(User principal, Long symptomId) {
        Long foundSymptomId = getSymptomById(symptomId).getId();
        symptomJpaRepository.deleteById(foundSymptomId);

        return true;
    }

    public Boolean ingredientRegister(User user, IngredientSaveCommand saveCommand) {
        return ingredientPlace(saveCommand);
    }

    private Boolean ingredientPlace(IngredientSaveCommand saveCommand) {
        Ingredient ingredient = ingredientCreate(saveCommand.getName());
        if (saveCommand.getSymptomIds().size() >= 1) {
            List<Symptom> symptoms = getSymptomsByIds(saveCommand.getSymptomIds());
            ingredientSymptomCreate(ingredient, symptoms);
        }
        return true;
    }

    private void ingredientSymptomCreate(Ingredient ingredient, List<Symptom> symptoms) {
        List<IngredientSymptom> list = new ArrayList<>();
        for (Symptom symptom : symptoms) {
            IngredientSymptom foundIngredient = IngredientSymptom.create(ingredient, symptom);
            foundIngredient.addOTM();
            list.add(foundIngredient);
        }
        ingredientSymptomJpaRepository.saveAll(list);
    }

    private List<Symptom> getSymptomsByIds(List<Long> symptomIds) {
        return ingredientRepositorySupport.findSymptomsByIds(symptomIds);
    }


    private Ingredient ingredientCreate(String name) {
        Ingredient ingredient = Ingredient.create(name);
        return ingredientJpaRepository.save(ingredient);
    }

    @Transactional
    public IngredientResponse ingredientConnectSymptom(User user, Long ingredientId, List<Long> symptomIds) {
        Ingredient ingredient=getIngredient(ingredientId);
        List<Symptom> symptoms=getSymptomsByIds(symptomIds);
        for (Symptom symptom:symptoms){
            ingredientSymptomJpaRepository.save(IngredientSymptom.create(ingredient,symptom).addOTM());
        }
        return new IngredientResponse(ingredient);

    }

    private Ingredient getIngredient(Long ingredientId) {
        return ingredientRepositorySupport.findById(ingredientId);
    }
}
