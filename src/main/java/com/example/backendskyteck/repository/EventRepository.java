package com.example.backendskyteck.repository;

import com.projectpi.projectpi.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
