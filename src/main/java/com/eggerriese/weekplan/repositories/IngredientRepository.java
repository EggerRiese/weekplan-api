package com.eggerriese.weekplan.repositories;

import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, Long> {
}
