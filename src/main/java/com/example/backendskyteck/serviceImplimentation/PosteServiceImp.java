package com.example.backendskyteck.serviceImplimentation;

import com.example.backendskyteck.entities.Poste;
import com.example.backendskyteck.entities.Room;
import com.example.backendskyteck.repository.PosteRepository;
import com.example.backendskyteck.repository.RoomRepository;
import com.example.backendskyteck.serviceInterface.IPosteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class PosteServiceImp implements IPosteService {
    PosteRepository posteRepository ;
    RoomRepository roomRepository ;
    @Override   //save poste in the room
    public Poste addPoste(Poste poste , Long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room!=null)
        {
            poste.setRoom(room);
            room.getPosts().add(poste);
            return posteRepository.save(poste) ;
        }
        else  {
            throw  new RuntimeException("Room not found with ID:"+ roomId);
        }
    }

    @Override
    public Poste updatePoste(Poste poste) {
        return posteRepository.save(poste);
    }

    @Override
    public List<Poste> postes() {
        List<Poste> postes = posteRepository.findAll() ;

        for ( Poste poste :postes){
            poste.setRoom(null);

        }
        return  postes ;
    }

    @Override
    public void removePoste(Long numPoste) {
        posteRepository.deleteById(numPoste);

    }
}
