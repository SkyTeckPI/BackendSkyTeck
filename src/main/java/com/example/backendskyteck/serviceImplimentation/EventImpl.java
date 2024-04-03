package com.example.backendskyteck.serviceImplimentation;

import com.projectpi.projectpi.Entity.Event;
import com.projectpi.projectpi.Repository.EventRepository;
import com.projectpi.projectpi.ServiceInterface.EventInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventImpl implements EventInterface {
    EventRepository repo;
    @Override
    public void createEvent(Event event) {
        repo.save(event);
    }

    @Override
    public Event getEventById(Long numEvent) {
        Optional<Event> optionalEvent = repo.findById(numEvent);
        return optionalEvent.orElse(null);
    }

    @Override
    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public void updateEvent(Long numEvent, Event event) {
        Optional<Event> optionalEvent = repo.findById(numEvent);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            // Update fields of existingEvent with fields of event
            existingEvent.setNom(event.getNom());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setDate(event.getDate());
            existingEvent.setHeure(event.getHeure());
            existingEvent.setNombreDePlace(event.getNombreDePlace());
            existingEvent.setPhotoUrl(event.getPhotoUrl());
            repo.save(existingEvent);
        } else {
            // Handle case where event with given id is not found
            // Possibly throw an exception or log a message
        }
    }


    @Override
    public void deleteEvent(Long numEvent) {
        repo.deleteById(numEvent);
    }
}
