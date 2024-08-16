package com.eggerriese.weekplan.services;

import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Optional<MealEntity> findOne(Long mealId) {
        return mealRepository.findById(mealId);
    }

    public List<MealEntity> findAll() {
        return StreamSupport.stream(mealRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    public MealEntity save(MealEntity mealEntity) {
       return mealRepository.save(mealEntity);
    }

    public MealEntity update(MealEntity mealEntity) {
        return mealRepository.findById(mealEntity.getId()).map(existingMeal -> {
            Optional.ofNullable(mealEntity.getName()).ifPresent(existingMeal::setName);

            return mealRepository.save(existingMeal);
        }).orElseThrow(() -> new RuntimeException("Meal does not exists"));
    }

    public void delete(Long mealId) {
        mealRepository.deleteById(mealId);
    }
}
