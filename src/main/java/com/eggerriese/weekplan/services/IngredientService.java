package com.eggerriese.weekplan.services;


import com.eggerriese.weekplan.domain.entities.IngredientEntity;

import java.util.List;
import java.util.Optional;

public interface IngredientService {

    Optional<IngredientEntity> findOne(Long ingredientId);

    List<IngredientEntity> findAll();

    IngredientEntity save(IngredientEntity ingredientEntity);

    void delete(Long ingredientId);
}
