package com.example.demo.controller;

import com.example.demo.entity.Checkbox;
// we will serve our checkbox
import com.example.demo.service.CheckboxService;
// we sent work to service
import org.springframework.http.ResponseEntity;
// HTTP responses
import org.springframework.web.bind.annotation.*;
// we import all web adnotation

import java.util.List;
import java.util.UUID;

@RestController
// automatically change format to JSON, not HTML
@RequestMapping("/api/checkboxes")
// address
@CrossOrigin(origins = "*")
// We can connect our API
public class CheckboxController {

    private final CheckboxService service;
    public CheckboxController(CheckboxService service) {
        this.service = service;
    }
    // when we create controller, we have to give it service

    @GetMapping
    public List<Checkbox> getAll() {
        return service.getAllCheckboxes();
    }
    // HTTP GET - what is happening when you type address
    // Gives List of All checkboxes

    @PostMapping
    public Checkbox create(@RequestBody Checkbox checkbox){
        return service.createCheckbox(checkbox);
    }
    // HTTP POST - change JSON to Java Checkbox

    @PatchMapping("/{id}")
    public Checkbox updateStatus(@PathVariable UUID id, @RequestParam boolean mark){
        return service.toggleMark(id,mark);
    }
    // Path variable - find by ID
    // Search for parameter after "?"
    // change mark

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.deleteCheckbox(id);
        return ResponseEntity.noContent().build();
    }
    // HTTP delete - return nothing
    // HTTP 204 - perfect, nothing to show more
    // .build() - last response for browser

}


