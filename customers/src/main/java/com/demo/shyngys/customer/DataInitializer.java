package com.demo.shyngys.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    
    private final CustomerRepository customerRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 0) {
            log.info("Initializing sample customer data...");
            
            Customer customer1 = Customer.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@example.com")
                    .phoneNumber("+1234567890")
                    .build();
            
            Customer customer2 = Customer.builder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .email("jane.smith@example.com")
                    .phoneNumber("+1987654321")
                    .build();
            
            Customer customer3 = Customer.builder()
                    .firstName("Bob")
                    .lastName("Johnson")
                    .email("bob.johnson@example.com")
                    .phoneNumber("+1555666777")
                    .build();
            
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            
            log.info("Sample customer data initialized successfully!");
        }
    }
} 