package com.example.backendskyteck.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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
    private String name;
    private String lastname;
    private String email;
    private ComplaintStatus status;
    private SatisfactionLevel note;

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeRec getTypeRec() {
        return typeRec;
    }

    public void setTypeRec(TypeRec typeRec) {
        this.typeRec = typeRec;
    }

    public LocalDateTime getDateComplaint() {
        return dateComplaint;
    }

    public void setDateComplaint(LocalDateTime dateComplaint) {
        this.dateComplaint = dateComplaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public SatisfactionLevel getNote() {
        return note;
    }

    public void setNote(SatisfactionLevel note) {
        this.note = note;
    }

}
