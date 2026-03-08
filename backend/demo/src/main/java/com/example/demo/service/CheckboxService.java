package com.example.demo.service;
// What is happening when we add checkbox, init methods from repository

import com.example.demo.entity.Checkbox;
// import object definition
import com.example.demo.repository.CheckboxRepository;
// import repository to database access
import org.springframework.stereotype.Service;
// import @Service, that is logical class
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
// Service - worker, create at start and hold him in memory
public class CheckboxService {
    private final CheckboxRepository repository;
    // private - no one can change repository
    // final - never will be change

    public CheckboxService(CheckboxRepository repository) {
        this.repository = repository;
    }
    // Dependency Injection - String gives new CheckboxRepository()

    public Checkbox createCheckbox(Checkbox checkbox){
        return repository.save(checkbox);
    }
    // Method will return save object
    // createChechbox - name of the method
    // parameter - checkbox
    // save() sent to db and return from db with ID

    public List<Checkbox> getAllCheckboxes() {
        return repository.findAll();
    }
    // List - collection checkboxes object
    // findAll - repo select * from checkboxes


    @Transactional
    public Checkbox toggleMark(UUID id, boolean isMarked) {
        Checkbox checkbox = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkbox not found"));
        checkbox.setMark(isMarked);
        return repository.save(checkbox);
    }
    // Transactional - do everything inside as one transaction!
    // If there is an error - rollback
    // FindById - look by ID
    // setMark - checkbox new value on RAM server
    // save - save on the database

    public void deleteCheckbox(UUID id){
        repository.deleteById(id);
    }
    // ID to know what to delete
    // Delete from chechboxes WHERE id = "..."
}
