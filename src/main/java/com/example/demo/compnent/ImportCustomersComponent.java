package com.example.demo.compnent;

import com.example.demo.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class ImportCustomersComponent implements ImportCustomers {

    private List<String> names = List.of("James", "Christopher", "Daniel", "Madeleine", "Melissa");
    private List<String> surnames = List.of("Brown", "White", "Red", "Black", "Blue");

    public List<Customer> importCustomers() {
        int count = getRandomNumber(9) + 1;
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            customers.add(generateUser());
        }
        return customers;
    }

    private Customer generateUser() {
        Function<List<String>, String> DRAW_STRING = list -> list.get(getRandomNumber(list.size()));
        return Customer.builder().firstName(DRAW_STRING.apply(names)).lastName(DRAW_STRING.apply(surnames)).build();

    }

    private int getRandomNumber(int max) {
        return (int) Math.floor(Math.random() * max);
    }
}
