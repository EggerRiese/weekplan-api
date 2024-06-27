package com.eggerriese.weekplan.services;

import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;

import java.util.Optional;

public interface WeekPlanService {

    void saveWeekPlan(WeekPlanEntity weekPlanEntity);

    Optional<WeekPlanEntity> getWeekPlan(Long id);
}
