package com.eggerriese.weekplan.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weekPlan")
public class WeekPlanEntity {

    @Id
    private Long id;

    private Long mondayMealId;

    private Long tuesdayMealId;

    private Long wednesdayMealId;

    private Long thursdayMealId;

    private Long fridayMealId;

    private Long saturdayMealId;

    private Long sundayMealId;
}
