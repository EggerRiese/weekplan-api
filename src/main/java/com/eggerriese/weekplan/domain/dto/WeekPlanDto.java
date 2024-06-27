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
    private Long id;

    private Long mondayMealId;

    private Long tuesdayMealId;

    private Long wednesdayMealId;

    private Long thursdayMealId;

    private Long fridayMealId;

    private Long saturdayMealId;

    private Long sundayMealId;

}
