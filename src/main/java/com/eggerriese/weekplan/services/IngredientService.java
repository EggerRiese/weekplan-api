package com.eggerriese.weekplan.services;

import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import com.eggerriese.weekplan.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Optional<IngredientEntity> findOne(Long ingredientId) {
        return ingredientRepository.findById(ingredientId);
    }

    public List<IngredientEntity> findAll() {
        return StreamSupport.stream(ingredientRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    public IngredientEntity save(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }

    public void delete(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
}
