package com.example.demo.restcontrollers;

import com.example.demo.Customer;
import com.example.demo.CustomerRepository;
import com.example.demo.compnent.ImportCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImportCustomerController {
    @Autowired
    private ImportCustomers importCustomers;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/import")
    public List<Customer> importCustomers() {
        List<Customer> importedCustomers = importCustomers.importCustomers();
        importedCustomers.forEach(customer -> {
            Customer savedCustomer = customerRepository.save(customer);
            customer.setId(savedCustomer.getId());
        });
        return importedCustomers;
    }
}
