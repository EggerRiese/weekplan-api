package com.eggerriese.weekplan.services.impl;

import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.repositories.WeekPlanRepository;
import com.eggerriese.weekplan.services.WeekPlanService;
import org.springframework.stereotype.Service;

@Service
public class WeekPlanServiceImpl implements WeekPlanService {

    private final WeekPlanRepository weekPlanRepository;

    public WeekPlanServiceImpl(WeekPlanRepository weekPlanRepository) {
        this.weekPlanRepository = weekPlanRepository;
    }

    @Override
    public void saveMealForTheDay(WeekPlanEntity weekPlanEntity) {
        weekPlanRepository.save(weekPlanEntity);
    }
}
