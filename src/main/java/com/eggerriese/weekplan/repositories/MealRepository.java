package com.eggerriese.weekplan.repositories;

import com.eggerriese.weekplan.domain.entities.MealEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<MealEntity, Long> {
}
