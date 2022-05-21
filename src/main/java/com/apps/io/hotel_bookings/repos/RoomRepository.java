package com.apps.io.hotel_bookings.repos;

import com.apps.io.hotel_bookings.entities.Room;
import com.apps.io.hotel_bookings.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    public Optional<Room> findByRoomType(RoomType roomType);

}
