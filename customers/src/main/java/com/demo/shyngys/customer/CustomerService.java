package com.demo.shyngys.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {
        log.info("Fetching all customers");
        return customerRepository.findAll();
    }
    
    public Optional<Customer> getCustomerById(Long id) {
        log.info("Fetching customer with id: {}", id);
        return customerRepository.findById(id);
    }
    
    public Customer createCustomer(Customer customer) {
        log.info("Creating new customer: {}", customer.getEmail());
        
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Customer with email " + customer.getEmail() + " already exists");
        }
        
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Long id, Customer customerDetails) {
        log.info("Updating customer with id: {}", id);
        
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(customerDetails.getFirstName());
                    customer.setLastName(customerDetails.getLastName());
                    customer.setEmail(customerDetails.getEmail());
                    customer.setPhoneNumber(customerDetails.getPhoneNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }
    
    public void deleteCustomer(Long id) {
        log.info("Deleting customer with id: {}", id);
        
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        
        customerRepository.deleteById(id);
    }
} 