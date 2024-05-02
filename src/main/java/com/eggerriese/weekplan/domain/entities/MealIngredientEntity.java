package com.eggerriese.weekplan.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "meal_definition")
public class MealIngredientEntity {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    private MealEntity meal;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    private String amount;
}
