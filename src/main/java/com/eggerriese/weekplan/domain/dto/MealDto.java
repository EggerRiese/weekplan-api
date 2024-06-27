package com.eggerriese.weekplan.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealDto {

    private Long id;

    private String name;

    private String description;

    private IngredientDto[] ingredients;
}
