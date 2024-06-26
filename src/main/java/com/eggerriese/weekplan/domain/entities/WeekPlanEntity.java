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
    private Long date;

    private long mondayMealId;

    private long tuesdayMealId;

    private long wednesdayMealId;

    private long thursdayMealId;

    private long fridayMealId;

    private long saturdayMealId;

    private long sundayMealId;
}
