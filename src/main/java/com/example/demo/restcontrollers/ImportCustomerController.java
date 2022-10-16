package com.example.demo.restcontrollers;

import com.example.demo.Customer;
import com.example.demo.compnent.ImportCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImportCustomerController {

    private ImportCustomers importCustomers;

    @Autowired
    public void setImportCustomersDao(final ImportCustomers importCustomers) {
        this.importCustomers = importCustomers;
    }

    @GetMapping("/import")
    public List<Customer> importCustomers() {
        return importCustomers.importCustomers();
    }
}
