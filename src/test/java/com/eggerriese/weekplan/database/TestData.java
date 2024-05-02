package com.eggerriese.weekplan.database;

import com.eggerriese.weekplan.domain.dto.MealDto;

public class TestData {
    private TestData() { }

    public static MealDto getMeal1() {
        return MealDto.builder()
                .id(1L)
                .name("Suppe")
                .description("fluessig")
                .build();
    }

    public static MealDto getMeal2() {
        return MealDto.builder()
                .id(2L)
                .name("Brot")
                .description("gebacken")
                .build();
    }

}
