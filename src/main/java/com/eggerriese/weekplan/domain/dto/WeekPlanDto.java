package com.eggerriese.weekplan.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeekPlanDto {

    // could be YEAR+WEEKNUMBER = 202401
    private long id;

    private long mondayMealId;

    private long tuesdayMealId;

    private long wednesdayMealId;

    private long thursdayMealId;

    private long fridayMealId;

    private long saturdayMealId;

    private long sundayMealId;

}
