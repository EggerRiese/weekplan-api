package com.eggerriese.weekplan.mapper.impl;

import com.eggerriese.weekplan.domain.dto.WeekPlanDto;
import com.eggerriese.weekplan.domain.entities.WeekPlanEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WeekPlanMapper implements Mapper<WeekPlanEntity, WeekPlanDto> {

    private final ModelMapper modelMapper;

    public WeekPlanMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public WeekPlanDto mapTo(WeekPlanEntity weekPlanEntity) {
        return modelMapper.map(weekPlanEntity, WeekPlanDto.class);
    }

    @Override
    public WeekPlanEntity mapFrom(WeekPlanDto weekPlanDto) {
        return modelMapper.map(weekPlanDto, WeekPlanEntity.class);
    }
}
