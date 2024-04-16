package com.example.backendskyteck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Room {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
     Long roomId ;
    String name ;
    private String Description ;
    private Instant createdDate ;
    @JsonIgnore
    @OneToMany (mappedBy = "room")
    List<Poste> posts ;

    //user
}
