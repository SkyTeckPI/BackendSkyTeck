package com.example.backendskyteck.controller;

import com.example.backendskyteck.entities.Poste;
import com.example.backendskyteck.serviceInterface.IPosteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Poste management " )
@RestController
@RequestMapping("/poste")
@AllArgsConstructor
public class PosteController {
    IPosteService IposteService ;

    @PostMapping("/add/{roomId}")
    public Poste addPoste(@RequestBody Poste poste, @PathVariable("roomId") Long RoomId) {
        return IposteService.addPoste(poste, RoomId);
    }
@PutMapping("/update")
    public Poste updatePoste(Poste poste) {
        return IposteService.updatePoste(poste);
    }

    @GetMapping("/all")
    public List<Poste> postes() {
        return IposteService.postes();
    }

    @DeleteMapping("/delete/{numPoste}")
    public void removePoste(@PathVariable("numPoste") Long numPoste) {
        IposteService.removePoste( numPoste);
    }
}
