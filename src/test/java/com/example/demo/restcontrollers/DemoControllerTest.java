package com.example.demo.restcontrollers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class DemoControllerTest {

    private MockMvc mvc;
    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(applicationContext.getBean(DemoController.class)).build();
    }

    @Test
    public void addCustomerThrowsExceptionIfParamIsMissings() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/add").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());

        mvc.perform(MockMvcRequestBuilders.post("/add?firstName=First").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());

        mvc.perform(MockMvcRequestBuilders.post("/add?lastName=Last").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void addCustomerIfParamsAreSet() throws Exception {
        MvcResult result =
                mvc.perform(MockMvcRequestBuilders.post("/add?firstName=First&lastName=Last").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assertions.assertEquals("OK", result.getResponse().getContentAsString());
    }


}