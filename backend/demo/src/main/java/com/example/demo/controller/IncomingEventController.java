package com.example.demo.controller;


import com.example.demo.entity.IncomingEvent;
import com.example.demo.entity.EventCategory;
import com.example.demo.service.IncomingEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/incomingevents")
@CrossOrigin(origins = "*")
public class IncomingEventController {

    private final IncomingEventService service;

    public IncomingEventController(IncomingEventService service) {
        this.service = service;
    }


    // (@RequestParam)
    //  /api/incomingevents
    // /api/incomingevents?category=HEALTH
    @GetMapping
    public List<IncomingEvent> getAll(@RequestParam(required = false) EventCategory category) {
        if (category != null) {
            return service.getEventsByCategory(category);
        }
        return service.getAllEvents();
    }

    @PostMapping
    public IncomingEvent create(@RequestBody IncomingEvent event) {
        return service.createEvent(event);
    }

    @PutMapping("/{id}")
    public IncomingEvent update(@PathVariable UUID id, @RequestBody IncomingEvent updatedEvent) {
        return service.updateEvent(
                id,
                updatedEvent.getTitle(),
                updatedEvent.getText(),
                updatedEvent.getEventDate(),
                updatedEvent.getCategory()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }}
