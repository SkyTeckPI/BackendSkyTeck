package com.example.backendskyteck.controller;


import com.example.backendskyteck.entities.Room;
import com.example.backendskyteck.serviceInterface.IRoomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Room management " )
@RestController
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {

    IRoomService iRoomService ;

    @PostMapping("/add")
    public Room addRoom(Room room) {
        return iRoomService.addRoom(room);
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        return iRoomService.updateRoom(room);
    }

    @GetMapping("/all")
    public List<Room> rooms() {
        return iRoomService.rooms();
    }
@DeleteMapping("delete/{numRoom}")
    public void removeRoom(@PathVariable ("numRoom") Long numRoom) {
        iRoomService.removeRoom(numRoom);
    }
}
