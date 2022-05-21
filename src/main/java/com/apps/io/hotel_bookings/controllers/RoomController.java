package com.apps.io.hotel_bookings.controllers;

import com.apps.io.hotel_bookings.entities.Room;
import com.apps.io.hotel_bookings.entities.RoomType;
import com.apps.io.hotel_bookings.exception.NoSuchRoomException;
import com.apps.io.hotel_bookings.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create-or-update-room")
    public Room createOrUpdateRoom(@RequestBody Room room) {
        return roomService.addOrUpdateRoom(room);
    }

    @GetMapping("get-all-rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

   @GetMapping("/find-by-roomId")
    public Room findRoomById(@RequestParam long roomId) throws NoSuchRoomException {
        return roomService.findRoomById(roomId);
   }

    @GetMapping("/find-by-room-type")
    public Room findRoomByType(@RequestParam RoomType roomType) throws NoSuchRoomException {
        return roomService.findRoomByRoomType(roomType);
    }

}
