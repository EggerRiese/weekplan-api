package com.eggerriese.weekplan.services;

import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;

public interface WeekPlanService {

    void saveMealForTheDay(WeekPlanEntity weekPlanEntity);
}
