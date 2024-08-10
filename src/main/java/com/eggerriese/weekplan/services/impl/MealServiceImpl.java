package com.eggerriese.weekplan.services.impl;

import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.repositories.MealRepository;
import com.eggerriese.weekplan.services.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Optional<MealEntity> findOne(Long mealId) {
        return mealRepository.findById(mealId);
    }

    @Override
    public List<MealEntity> findAll() {
        return StreamSupport.stream(mealRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public MealEntity save(MealEntity mealEntity) {
       return mealRepository.save(mealEntity);
    }

    @Override
    public MealEntity update(MealEntity mealEntity) {
        return mealRepository.findById(mealEntity.getId()).map(existingMeal -> {
            Optional.ofNullable(mealEntity.getName()).ifPresent(existingMeal::setName);

            return mealRepository.save(existingMeal);
        }).orElseThrow(() -> new RuntimeException("Meal does not exists"));
    }

    @Override
    public void delete(Long mealId) {
        mealRepository.deleteById(mealId);
    }
}
