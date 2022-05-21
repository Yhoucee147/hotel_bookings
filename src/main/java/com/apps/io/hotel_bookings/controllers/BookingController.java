package com.apps.io.hotel_bookings.controllers;

import com.apps.io.hotel_bookings.entities.Booking;
import com.apps.io.hotel_bookings.entities.Customer;
import com.apps.io.hotel_bookings.exception.NoSuchBookingException;
import com.apps.io.hotel_bookings.exception.NoSuchCustomerException;
import com.apps.io.hotel_bookings.exception.RoomNotAvailableException;
import com.apps.io.hotel_bookings.services.BookingService;
import com.apps.io.hotel_bookings.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create-update-booking")
    public Booking createOrUpdateBooking(Booking booking) throws RoomNotAvailableException {
        return bookingService.createOrUpdateBooking(booking);
    }

    @GetMapping("/all-booking-for-customer")
    public List<Booking> getAllBookingForCustomer(@RequestParam String customerEmail) throws NoSuchCustomerException {
        Customer customer = customerService.findCustomerByEmail(customerEmail);
        return bookingService.getAllBookingsForCustomer(customer);
    }

    @GetMapping("/get-booking")
    public Booking getBooking(@RequestParam long bookingId) throws NoSuchBookingException {
        return bookingService.findBooking(bookingId);
    }

    @GetMapping("/get-all-bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

}
