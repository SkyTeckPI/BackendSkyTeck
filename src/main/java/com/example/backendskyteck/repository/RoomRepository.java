package com.example.backendskyteck.repository;

import com.example.backendskyteck.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room,Long> {

    Room findByName(String name );
}
