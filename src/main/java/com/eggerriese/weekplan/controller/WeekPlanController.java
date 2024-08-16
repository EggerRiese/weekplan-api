package com.eggerriese.weekplan.controller;

import com.eggerriese.weekplan.domain.dto.IngredientDto;
import com.eggerriese.weekplan.domain.dto.WeekPlanDto;
import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import com.eggerriese.weekplan.services.WeekPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class WeekPlanController {

    @Autowired
    private WeekPlanService weekPlanService;

    @Autowired
    private Mapper<WeekPlanEntity, WeekPlanDto> weekPlanMapper;

    @Autowired
    private Mapper<IngredientEntity, IngredientDto> ingredientMapper;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/weeks")
    public ResponseEntity<String> setWeekPlan(@RequestBody WeekPlanDto weekPlanDto) {
        if (weekPlanDto.getId() <= LocalDateTime.now().getYear() * 100L
                && weekPlanDto.getId() > (LocalDateTime.now().getYear() + 2) * 100L) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        weekPlanService.saveWeekPlan(weekPlanMapper.mapFrom(weekPlanDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/weeks/{id}")
    public ResponseEntity<List<IngredientDto>> getWeekPlan(@PathVariable Long id) {
        Optional<List<IngredientEntity>> foundWeekPlan = weekPlanService.getWeekPlan(id);

        return foundWeekPlan.map(ingredientEntities -> new ResponseEntity<>(ingredientEntities
                .stream()
                .map(ingredient -> ingredientMapper.mapTo(ingredient))
                .collect(Collectors.toList()), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
