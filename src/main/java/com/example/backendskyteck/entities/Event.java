package com.example.backendskyteck.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event implements Serializable {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numEvent;
    String nom;
    String description;
    Date date;
    String heure;
    int nombreDePlace;
    String PhotoUrl;
}
