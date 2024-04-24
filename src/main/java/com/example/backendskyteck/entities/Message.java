package com.example.backendskyteck.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String content;
    Date date;

    @ToString.Exclude
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "receiver_uuid")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "sender_uuid")
    private User sender;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
