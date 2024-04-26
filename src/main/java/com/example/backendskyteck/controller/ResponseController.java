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
import com.example.backendskyteck.serviceImplimentation.ICompResService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/response")
public class ResponseController {

    private final ICompResService iCompResService;

    private final ComplaintRepository complaintRepository;
    @GetMapping
    public ResponseEntity<List<Response>> getAllResponse() {
        List<Response> response = iCompResService.getAllResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/showResponse")
    public ResponseEntity<Response> getResponseById(@RequestParam("id") int id) {
        Optional<Response> response = iCompResService.getResponseById(id);


        return response.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/Respond")
    public ResponseEntity<Response> createResponse(@RequestBody Response response,@RequestParam("idComp") int idComp) {

            Complaint complaint = complaintRepository.findById(idComp).orElse(null);



            response.setResponseDate(LocalDateTime.now());
            response.setAdminId(0);
            response.setComplaint(complaint);

            Response savedResponse = iCompResService.createResponse(response);
            return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);

    }

    // Update documents
    @PutMapping
    public ResponseEntity<Response> updateResponse(@RequestParam("id") int id, @RequestBody Response UpdatedResponse) {
        return iCompResService.getResponseById(id).map(Resp -> {
            return ResponseEntity.ok(iCompResService.updateResponse(Resp, UpdatedResponse));
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }
    // Delete documents

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable int id) {
        iCompResService.deleteResponse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
