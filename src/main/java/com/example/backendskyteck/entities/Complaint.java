package com.example.backendskyteck.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComp;
    private String description;
    private TypeRec typeRec;
    private LocalDateTime dateComplaint;
    private ComplaintStatus status;
    private SatisfactionLevel note;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;

}
