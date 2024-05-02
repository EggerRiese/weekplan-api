package com.eggerriese.weekplan.mapper.impl;

import com.eggerriese.weekplan.domain.dto.IngredientDto;
import com.eggerriese.weekplan.domain.entities.IngredientEntity;
import com.eggerriese.weekplan.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper implements Mapper<IngredientEntity, IngredientDto> {

    private final ModelMapper modelMapper;

    public IngredientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public IngredientDto mapTo(IngredientEntity IngredientEntity) {
        return modelMapper.map(IngredientEntity, IngredientDto.class);
    }

    @Override
    public IngredientEntity mapFrom(IngredientDto IngredientDto) {
        return modelMapper.map(IngredientDto, IngredientEntity.class);
    }
}
