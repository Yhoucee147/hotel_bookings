package com.apps.io.hotel_bookings.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rommId;
    @Column
    private String roomNumber;
    @Column
    private RoomType roomType;
    @Column
    private double roomPrice;
    @OneToMany(mappedBy = "room")
    Set<Booking> bookings;


}
