package com.example.backendskyteck.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Complaint {


    @Id private int idComp;
    private String description;
    private TypeRec typeRec;
    private LocalDateTime dateComplaint;
    private String name;
    private String lastname;
    private String email;

    private ComplaintStatus status = getStatus();

    private SatisfactionLevel note;

}
