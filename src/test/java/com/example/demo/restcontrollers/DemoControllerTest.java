package com.example.demo.restcontrollers;

import com.example.demo.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
class DemoControllerTest {

    @Autowired
    MockMvc mvc;

    @BeforeEach
    public void setup() {
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        DemoController controller = new DemoController();
        controller.setCustomerRepository(customerRepository);
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
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