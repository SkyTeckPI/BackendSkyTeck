package com.example.backendskyteck.serviceInterface;

import com.example.backendskyteck.entities.Poste;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPosteService {
    Poste addPoste(Poste poste , Long RoomId); // creating the poste and adding it to a room
    Poste updatePoste(Poste poste); //update a poste within a room
    List<Poste> postes(); //maybe see all my postes


    void removePoste(Long numPoste);  //even tho it needs to ba saved in history hmmm


}
