package com.eggerriese.weekplan.controller;

import com.eggerriese.weekplan.domain.dto.MealDto;
import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import com.eggerriese.weekplan.services.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MealController {

    private final MealService mealService;

    private final Mapper<MealEntity, MealDto> mealMapper;

    public MealController(MealService mealService, Mapper<MealEntity, MealDto> mealMapper) {
        this.mealService = mealService;
        this.mealMapper = mealMapper;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/meals")
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto meal) {
        MealEntity mealEntity = mealMapper.mapFrom(meal);
        //return new ResponseEntity<>(HttpStatus.OK);
        MealEntity savedMealEntity = mealService.save(mealEntity);

        return new ResponseEntity<>(mealMapper.mapTo(savedMealEntity), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/meals")
    public List<MealDto> getMeals() {
        List<MealEntity> meals = mealService.findAll();

        return meals.stream()
                .map(mealMapper::mapTo)
                .collect(Collectors.toList());
    }

    @DeleteMapping(path = "/meals/{id}")
    public ResponseEntity<MealDto> getMeal(@PathVariable("id") Long id) {
        mealService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
