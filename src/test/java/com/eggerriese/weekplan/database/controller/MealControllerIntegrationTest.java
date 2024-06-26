package com.eggerriese.weekplan.database.controller;

import com.eggerriese.weekplan.database.TestData;
import com.eggerriese.weekplan.domain.dto.MealDto;
import com.eggerriese.weekplan.domain.entities.MealEntity;
import com.eggerriese.weekplan.services.MealService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class MealControllerIntegrationTest {

    private MealService mealService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    public MealControllerIntegrationTest(MockMvc mockMvc, MealService mealService) {
        this.mockMvc = mockMvc;
        this.mealService = mealService;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void test() throws Exception {
        MealDto meal = TestData.getMeal1();

        String mealJson = objectMapper.writeValueAsString(meal);

        mockMvc.perform(MockMvcRequestBuilders
                    .post("/meals")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mealJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
