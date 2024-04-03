package com.example.backendskyteck.controller;

import com.projectpi.projectpi.Entity.Event;
import com.projectpi.projectpi.ServiceInterface.EventInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {
EventInterface eventInterface;
@PostMapping("/add")
    public String createEvent(Event event) {
    try {
        eventInterface.createEvent(event);
        return "Event created successfully";
    } catch (Exception e) {
        return "Error creating event : " + e.getMessage();
    }
    }
@GetMapping("/get/{numEvent}")

public Object getEventById(@PathVariable("numEvent") Long numEvent) {
    Event event = eventInterface.getEventById(numEvent);
    if (event != null) {
        return event;
    } else {
        return "Event not found for ID: " + numEvent;
    }
    }
@GetMapping("/getevent")
    public List<Event> getAllEvents() {
        return eventInterface.getAllEvents();
    }
@PutMapping("/update/{numEvent}")
public String updateEvent(@PathVariable("numEvent") Long numEvent, @RequestBody Event event) {
    try {
        eventInterface.updateEvent(numEvent, event);
        return "Event updated successfully";
    } catch (Exception e) {
        return "Error updating event : " + e.getMessage();
    }
    }
@DeleteMapping("/delete/{id}")
public String deleteEvent(@PathVariable("id") Long numEvent) {
    try {
        eventInterface.deleteEvent(numEvent);
        return "Event deleted successfully";
    } catch (Exception e) {
        return "Error deleting event: " + e.getMessage();
    }
}
}
