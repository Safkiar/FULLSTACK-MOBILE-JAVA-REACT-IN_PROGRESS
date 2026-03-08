package com.example.demo.service;


import com.example.demo.entity.IncomingEvent;
import com.example.demo.entity.EventCategory;
import com.example.demo.repository.IncomingEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class IncomingEventService {

    private final IncomingEventRepository repository;

    public IncomingEventService(IncomingEventRepository repository) {
        this.repository = repository;
    }

    public IncomingEvent createEvent(IncomingEvent event) {
        return repository.save(event);
    }

    public List<IncomingEvent> getAllEvents() {
        return repository.findAll();
    }

    public List<IncomingEvent> getEventsByCategory(EventCategory category) {

        return repository.findByCategory(category);
    }

    @Transactional
    public IncomingEvent updateEvent(UUID id, String newTitle, String newText, LocalDateTime newDate,EventCategory newCategory) {
        IncomingEvent event = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(newTitle);
        event.setText(newText);
        event.setEventDate(newDate);
        event.setCategory(newCategory);

        return repository.save(event);
    }



    public void deleteEvent(UUID id) {
        repository.deleteById(id);
    }

}