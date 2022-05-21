package com.apps.io.hotel_bookings.services;

import com.apps.io.hotel_bookings.entities.Booking;
import com.apps.io.hotel_bookings.entities.Customer;
import com.apps.io.hotel_bookings.exception.NoSuchBookingException;
import com.apps.io.hotel_bookings.exception.RoomNotAvailableException;
import com.apps.io.hotel_bookings.repos.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createOrUpdateBooking(Booking booking) throws RoomNotAvailableException {
        List<Booking> allRunningBookingsForRoom = booking.getRoom().getBookings().stream()
                .filter(b -> b.isBookingActuated() == false && b.isPaymentCompleted() == false)
                .collect(Collectors.toList());
        boolean isAvailable = Boolean.TRUE;
        for (Booking b : allRunningBookingsForRoom) {
            if (b.getLodgingStartTime().isBefore(booking.getLodgingStartTime()) &&
                    b.getLodgingEndTime().isAfter(booking.getLodgingEndTime())) {
                isAvailable = Boolean.FALSE;
            }
        }
        if (isAvailable) {
            booking.setBookingDate(LocalDate.now());
            return bookingRepository.save(booking);
        } else {
            throw new RoomNotAvailableException("Room not available for the specified period!");
        }
    }

    public List<Booking> getAllBookingsForCustomer(Customer customer) {
        return bookingRepository.findByCustomer(customer);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking findBooking(long bookingId) throws NoSuchBookingException {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new NoSuchBookingException("No booking for provided booking ID");
        }
    }

}
