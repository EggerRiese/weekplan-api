package com.eggerriese.weekplan.services;


import com.eggerriese.weekplan.domain.entities.MealEntity;

import java.util.List;
import java.util.Optional;

public interface MealService {

    Optional<MealEntity> findOne(Long mealId);

    List<MealEntity> findAll();

    MealEntity save(MealEntity MealEntity);

    MealEntity update(MealEntity MealEntity);

    void delete(Long mealId);
}
