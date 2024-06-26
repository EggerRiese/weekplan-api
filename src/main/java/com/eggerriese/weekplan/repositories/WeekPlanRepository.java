package com.eggerriese.weekplan.repositories;

import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekPlanRepository extends CrudRepository<WeekPlanEntity, String> {
}
