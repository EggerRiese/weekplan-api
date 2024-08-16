package com.eggerriese.weekplan.services;

import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.repositories.MealRepository;
import com.eggerriese.weekplan.repositories.WeekPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeekPlanService {

    @Autowired
    private WeekPlanRepository weekPlanRepository;

    @Autowired
    private MealRepository mealRepository;

    public void saveWeekPlan(WeekPlanEntity weekPlanEntity) {
        weekPlanRepository.save(weekPlanEntity);
    }

    public Optional<List<IngredientEntity>> getWeekPlan(Long id) {
        return weekPlanRepository.findById(id).map(weekPlan -> {

            // Collect meal IDs, including duplicates
            List<Long> mealIds = Arrays.asList(
                    weekPlan.getMondayMealId(),
                    weekPlan.getTuesdayMealId(),
                    weekPlan.getWednesdayMealId(),
                    weekPlan.getThursdayMealId(),
                    weekPlan.getFridayMealId(),
                    weekPlan.getSaturdayMealId(),
                    weekPlan.getSundayMealId()
            );

            // Fetch meals individually based on their IDs
            List<MealEntity> meals = mealIds.stream()
                    .map(mealId -> mealRepository.findById(mealId))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .toList();

            Map<String, IngredientEntity> ingredientMap = new HashMap<>();

            for (MealEntity meal : meals) {
                for (IngredientEntity ingredient : meal.getIngredients()) {
                    ingredientMap.merge(ingredient.getName(), ingredient.clone(),
                            (existing, newIngredient) -> {
                                existing.setAmount(existing.getAmount() + newIngredient.getAmount());
                                return existing;
                            });
                }
            }

            return new ArrayList<>(ingredientMap.values());
        });
    }
}
