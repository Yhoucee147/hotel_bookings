package com.apps.io.hotel_bookings.repos;

import com.apps.io.hotel_bookings.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findByEmail(String email);

}
