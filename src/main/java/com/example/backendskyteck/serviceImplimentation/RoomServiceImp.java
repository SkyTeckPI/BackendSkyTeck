package com.example.backendskyteck.serviceImplimentation;

import com.example.backendskyteck.entities.Room;
import com.example.backendskyteck.repository.RoomRepository;
import com.example.backendskyteck.serviceInterface.IRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImp implements IRoomService {
    RoomRepository roomRepository ;

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> rooms() {
        return roomRepository.findAll();
    }

    @Override
    public void removeRoom(Long numRoom) {
        roomRepository.deleteById( numRoom);

    }
}
