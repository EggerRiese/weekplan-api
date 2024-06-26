package com.eggerriese.weekplan.controller;

import com.eggerriese.weekplan.domain.dto.WeekPlanDto;
import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import com.eggerriese.weekplan.services.WeekPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class WeekPlanController {

    private final WeekPlanService weekPlanService;

    private final Mapper<WeekPlanEntity, WeekPlanDto> weekPlanMapper;

    public WeekPlanController(WeekPlanService weekPlanService, Mapper<WeekPlanEntity, WeekPlanDto> weekPlanMapper) {
        this.weekPlanService = weekPlanService;
        this.weekPlanMapper = weekPlanMapper;
    }

    @PostMapping(path = "/weekplan")
    public ResponseEntity<String> setMealForTheDay(@RequestBody WeekPlanDto weekPlanDto) {
        if (weekPlanDto.getId() <= LocalDateTime.now().getYear() * 100L
                && weekPlanDto.getId() > (LocalDateTime.now().getYear() + 2) * 100L) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        weekPlanService.saveMealForTheDay(weekPlanMapper.mapFrom(weekPlanDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
