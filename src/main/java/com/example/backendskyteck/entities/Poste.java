package com.example.backendskyteck.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Poste {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long postId ;
    String postName ;
     String description ;
     Instant createdDate ;

     @ManyToOne
     Room room ;

     @OneToMany(mappedBy = "poste")
    List<Comment> comments ;

     //user




}
