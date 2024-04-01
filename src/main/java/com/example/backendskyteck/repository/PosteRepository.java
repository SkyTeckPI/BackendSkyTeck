package com.example.backendskyteck.repository;

import com.example.backendskyteck.entities.Poste;
import com.example.backendskyteck.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PosteRepository extends JpaRepository<Poste,Long> {

    List<Poste> findAllByRoom(Room room);

    //findByUser
}
