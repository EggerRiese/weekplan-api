package com.eggerriese.weekplan.services.impl;

import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import com.eggerriese.weekplan.repositories.IngredientRepository;
import com.eggerriese.weekplan.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Optional<IngredientEntity> findOne(long ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    @Override
    public List<IngredientEntity> findAll() {
        return StreamSupport.stream(ingredientRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientEntity save(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }

    @Override
    public void delete(long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
