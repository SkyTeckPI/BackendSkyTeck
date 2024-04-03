package com.example.backendskyteck.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backendskyteck.repository.ComplaintRepository;
import com.example.backendskyteck.entities.Complaint;
import com.example.backendskyteck.entities.Response;
import com.example.backendskyteck.serviceInterface.ICompResService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/response")
public class ResponseController {
    @Autowired
    private ICompResService iCompResService;
    @Autowired
    private ComplaintRepository complaintRepository;
    @GetMapping
    public ResponseEntity<List<Response>> getAllResponse() {
        List<Response> response = iCompResService.getAllResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Get documents by id
    @GetMapping("/{id}")
    public ResponseEntity<Response> getComplaintById(@PathVariable int id) {
        Optional<Response> response = iCompResService.getResponseById(id);


        return response.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<Response> createResponse(@RequestBody Response response) {

            Complaint complaint = complaintRepository.findById(response.getComplaint().getIdComp()).orElse(null);



            response.setResponseDate(LocalDateTime.now());
            response.setAdminId(0);
            response.setComplaint(complaint);

            Response savedResponse = iCompResService.createResponse(response);
            return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);

    }

    // Update documents
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateResponse(@PathVariable int id, @RequestBody Response response) {
        Optional<Response> oldResponse = iCompResService.getResponseById(id);
        if (oldResponse.isPresent()) {
            response.setIdRep(id);
            Response updatedResponse = iCompResService.updateResponse(response);
            return new ResponseEntity<>(updatedResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    // Delete documents

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable int id) {
        iCompResService.deleteResponse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
