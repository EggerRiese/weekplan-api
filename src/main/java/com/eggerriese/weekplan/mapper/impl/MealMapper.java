package com.eggerriese.weekplan.mapper.impl;

import com.eggerriese.weekplan.domain.dto.MealDto;
import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MealMapper implements Mapper<MealEntity, MealDto> {

    private final ModelMapper modelMapper;

    public MealMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MealDto mapTo(MealEntity mealEntity) {
        return modelMapper.map(mealEntity, MealDto.class);
    }

    @Override
    public MealEntity mapFrom(MealDto mealDto) {
        return modelMapper.map(mealDto, MealEntity.class);
    }
}
