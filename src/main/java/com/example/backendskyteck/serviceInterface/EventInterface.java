package com.example.backendskyteck.serviceInterface;

import com.projectpi.projectpi.Entity.Event;

import java.util.List;

public interface EventInterface {
    // Create
    void createEvent(Event event);

    // Read
    Event getEventById(Long NumEvent);
    List<Event> getAllEvents();

    // Update
    void updateEvent(Long NumEvent, Event event);

    // Delete
    void deleteEvent(Long NumEvent);
}
