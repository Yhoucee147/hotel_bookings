package com.apps.io.hotel_bookings.repos;

import com.apps.io.hotel_bookings.entities.Booking;
import com.apps.io.hotel_bookings.entities.Customer;
import com.apps.io.hotel_bookings.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findByCustomer(Customer customer);

    public List<Booking> findByRoom(Room room);

}
