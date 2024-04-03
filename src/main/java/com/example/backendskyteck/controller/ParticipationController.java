package com.example.backendskyteck.controller;

import com.projectpi.projectpi.Entity.Participation;
import com.projectpi.projectpi.ServiceInterface.ParticipationInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/part")
public class ParticipationController {
    @PostMapping("/{NumEvent}/{Id}")
    public Participation participate(@PathVariable Long Id, @PathVariable Long NumEvent) {
        return participationInterface.participate(Id, NumEvent);
    }
    @PutMapping("/accept/{IdPart}")
    public String acceptParticipation(@PathVariable Long IdPart) {
        try {
            participationInterface.acceptParticipation(IdPart);
            return "Participation accepted successfully.";
        } catch (Exception e) {
            return "Failed to accept participation: " + e.getMessage();
        }
    }
    @DeleteMapping("/reject/{IdPart}")
    public String rejectParticipation(@PathVariable Long IdPart) {
        try {
            participationInterface.rejectParticipation(IdPart);
            return "Participation rejected successfully.";
        } catch (Exception e) {
            return "Failed to reject participation: " + e.getMessage();
        }
    }
    @PostMapping("/{IdPart}/archive")
    public String archiveParticipation(@PathVariable Long IdPart) {
        try {
            Participation participation = participationInterface.archiveParticipation(IdPart);
            return "Participation with ID " + IdPart + " archived successfully.";
        } catch (IllegalArgumentException e) {
            return "Failed to archive participation: " + e.getMessage();
        }
    }
    ParticipationInterface participationInterface;

}
