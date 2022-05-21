package com.apps.io.hotel_bookings.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Column
    private LocalDate bookingDate;
    @Column
    private LocalDateTime lodgingStartTime;
    @Column
    private LocalDateTime lodgingEndTime;
    @Column(nullable = false)
    private boolean bookingActuated = Boolean.FALSE;
    @Column(nullable = false)
    private boolean paymentCompleted = Boolean.FALSE;


}
