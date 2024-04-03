package com.example.backendskyteck.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Cours implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idC ;
    String title ;
    LocalDate dateadded ;
    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    Set<Quiz> quiz;


}
