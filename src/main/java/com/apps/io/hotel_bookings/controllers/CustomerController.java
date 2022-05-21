package com.apps.io.hotel_bookings.controllers;

import com.apps.io.hotel_bookings.entities.Customer;
import com.apps.io.hotel_bookings.exception.NoSuchCustomerException;
import com.apps.io.hotel_bookings.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create-or-update-customer")
    public Customer createOrUpdateCustomer(Customer customer) {
        return customerService.addOrUpdateCustomer(customer);
    }

    @GetMapping("/find-customer-by-email")
    public Customer findCustomerByEmail(@RequestParam String email) throws NoSuchCustomerException {
        return customerService.findCustomerByEmail(email);
    }

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
