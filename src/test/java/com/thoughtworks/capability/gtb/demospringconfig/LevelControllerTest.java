package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wudibin
 * 2020/11/17
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "levelNumber = 0")
public class LevelControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void should_get_basic_when_level_number_less_than_one() throws Exception {
        mockMvc.perform(get("/level")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("basic")));
    }

}
