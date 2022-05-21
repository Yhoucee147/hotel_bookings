package com.apps.io.hotel_bookings.services;

import com.apps.io.hotel_bookings.entities.Room;
import com.apps.io.hotel_bookings.entities.RoomType;
import com.apps.io.hotel_bookings.exception.NoSuchRoomException;
import com.apps.io.hotel_bookings.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addOrUpdateRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(long roomId) throws NoSuchRoomException {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new NoSuchRoomException("No room with the provided room Id");
        }
    }

    public Room findRoomByRoomType(RoomType roomType) throws NoSuchRoomException {
        Optional<Room> room = roomRepository.findByRoomType(roomType);
        if (room.isPresent()) {
            return room.get();
        } else {
            throw new NoSuchRoomException("No room for the provided room type");
        }
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

}
