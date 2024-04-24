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

public class Response {

    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRep;
    private String description;
    private LocalDateTime responseDate;
    private int AdminId;

    @ToString.Exclude
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "complaint_id_comp", nullable = false)
    private Complaint complaint;

}
