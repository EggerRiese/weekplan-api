package com.eggerriese.weekplan.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealIngredientDto {

    private long mealId;

    private long ingredientId;

    private String amount;
}
