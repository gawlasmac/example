package com.example.demo.restcontrollers;

import com.example.demo.Customer;
import com.example.demo.CustomerRepository;
import com.example.demo.aspect.LogTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")
    public String addCustomer(@RequestParam final String firstName, @RequestParam final String lastName) {
        customerRepository.save(Customer.builder().firstName(firstName).lastName(lastName).build());
        return "OK";
    }

    @GetMapping("/list")
    @LogTime
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerByOd(@PathVariable Integer id) {
        return customerRepository.findById(id).get()
    }


}
