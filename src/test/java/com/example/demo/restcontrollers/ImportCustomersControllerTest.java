package com.example.demo.restcontrollers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImportCustomersControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(applicationContext.getBean(ImportCustomerController.class)).build();
    }
}
