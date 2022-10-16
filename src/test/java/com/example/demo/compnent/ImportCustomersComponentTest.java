package com.example.demo.compnent;

import com.example.demo.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class ImportCustomersComponentTest {

    @Autowired
    private ApplicationContext applicationContext;

    private ImportCustomers importCustomers;

    @BeforeEach
    public void setup() {
        importCustomers = applicationContext.getBean(ImportCustomersComponent.class);
    }

    @Test
    public void importCustomersShouldReturnNotEmptyList() {
        List<Customer> result = importCustomers.importCustomers();
        Assertions.assertFalse(CollectionUtils.isEmpty(result));
    }
}
