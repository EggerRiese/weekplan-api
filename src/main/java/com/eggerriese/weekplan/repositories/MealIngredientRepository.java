package com.eggerriese.weekplan.repositories;

import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.domain.entities.MealIngredientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealIngredientRepository extends CrudRepository<MealIngredientEntity, Long> {
}
