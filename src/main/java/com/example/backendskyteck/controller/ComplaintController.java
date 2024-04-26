package com.example.backendskyteck.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backendskyteck.entities.Complaint;
import com.example.backendskyteck.entities.ComplaintStatus;
import com.example.backendskyteck.entities.SatisfactionLevel;
import com.example.backendskyteck.serviceImplimentation.ICompResService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@RestController
@RequestMapping("/api/complaint")
@AllArgsConstructor
public class ComplaintController {
    private final ICompResService iCompResService;
    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaint() {
        List<Complaint> complaints = iCompResService.getAllComplaint();
        return new ResponseEntity<>(complaints, HttpStatus.OK);
    }
    // Get complaint by id
    @GetMapping("/complaintShow")
    public ResponseEntity<Complaint> getComplaintById(@RequestParam ("id") int idComp) {
        Optional<Complaint> complaint = iCompResService.getComplaintById(idComp);
        return complaint.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create complaint
    @PostMapping
    public ResponseEntity<Complaint> createComplaint  (@RequestBody Complaint complaint) {
        try {
            Complaint newComplaint = iCompResService.createComplaint(complaint);
            return new ResponseEntity<>(newComplaint, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update complaint
    @PutMapping
    public ResponseEntity updateComplaint(
            @RequestParam("idComp") int id
            , @RequestBody Complaint updatedComplaint) {
        return iCompResService.getComplaintById(id).map(comp -> {
            return ResponseEntity.ok(iCompResService.updateComplaint(comp, updatedComplaint));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete complaint
    @DeleteMapping("/{id}")
    public ResponseEntity deleteComplaint(@PathVariable int id) {
        iCompResService.deleteComplaint(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // ONLY IF REC IS TREATED
    @PutMapping("/give-note")
    public ResponseEntity<?> giveNote(@RequestParam("id") int id, @RequestParam("note") String note) throws Exception{
        Complaint c = iCompResService.getComplaintById(id).orElse(null);
        if (c == null) {
            return new ResponseEntity<>(Arrays.asList("Complaint NOT FOUND"), HttpStatus.NOT_FOUND);
        }
        if (!c.getStatus().toString().equals(ComplaintStatus.TREATED.toString())) {
            return new ResponseEntity<>(Arrays.asList("Complaint is Not Treated Yet."), HttpStatus.BAD_REQUEST);
        }
        else{
            switch (note.toUpperCase(Locale.ROOT)){
                case "VERY SATISFIED":
                    c.setNote(SatisfactionLevel.VERY_SATISFIED);
                    break;

                case "SATISFIED":
                    c.setNote(SatisfactionLevel.SATISFIED);
                    break;

                case "NEUTRAL":
                    c.setNote(SatisfactionLevel.NEUTRAL);
                    break;

                case "NOT SATISFIED":
                    c.setNote(SatisfactionLevel.NOT_SATISFIED);
                    break;

                default: throw new Exception("UNKNOWN SatisfactionLevel !");
            }
            Complaint updated = iCompResService.updateComplaint(c);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }

    }





}
