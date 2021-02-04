package com.example.customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomersApplication {

    private final CustomerRepository customerRepository;

    public CustomersApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> customerRepository.saveAll(createCustomers());
    }

    private List<Customer> createCustomers() {
        return Arrays.asList(
                new Customer(1L, "Przemek", "Raczkowski"),
                new Customer(2L, "Tomek", "Jakistamski"),
                new Customer(3L, "Paulo", "Sausa")
        );
    }

}
