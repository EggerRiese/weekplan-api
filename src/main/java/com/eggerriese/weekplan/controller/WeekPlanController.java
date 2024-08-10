package com.eggerriese.weekplan.controller;

import com.eggerriese.weekplan.domain.dto.WeekPlanDto;
import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import com.eggerriese.weekplan.services.WeekPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class WeekPlanController {

    private final WeekPlanService weekPlanService;

    private final Mapper<WeekPlanEntity, WeekPlanDto> weekPlanMapper;

    public WeekPlanController(WeekPlanService weekPlanService, Mapper<WeekPlanEntity, WeekPlanDto> weekPlanMapper) {
        this.weekPlanService = weekPlanService;
        this.weekPlanMapper = weekPlanMapper;
    }

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
    public ResponseEntity<WeekPlanDto> getWeekPlan(@PathVariable Long id) {
        Optional<WeekPlanEntity> foundWeekPlan = weekPlanService.getWeekPlan(id);

        return foundWeekPlan
                .map(weekPlanEntity -> new ResponseEntity<>(weekPlanMapper.mapTo(weekPlanEntity), HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
