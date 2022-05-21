package com.apps.io.hotel_bookings.services;

import com.apps.io.hotel_bookings.entities.Customer;
import com.apps.io.hotel_bookings.exception.NoSuchCustomerException;
import com.apps.io.hotel_bookings.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerByEmail(String email) throws NoSuchCustomerException {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new NoSuchCustomerException("No customer with Provided Email");
        }
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
