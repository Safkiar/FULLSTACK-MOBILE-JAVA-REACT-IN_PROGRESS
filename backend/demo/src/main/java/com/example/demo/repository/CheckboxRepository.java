package com.example.demo.repository;

import com.example.demo.entity.Checkbox;
// class import
import org.springframework.data.jpa.repository.JpaRepository;
// CRUD download
import org.springframework.stereotype.Repository;
// repo - store

import java.util.UUID;
import java.util.List;

@Repository
// Create this object automatically,
public interface CheckboxRepository extends JpaRepository<Checkbox,UUID>{
// Create an interface
// Service Checkbox table with this key
    List<Checkbox> findByUserId(UUID userId);
    // Result - List<Checkbox>
    // findBy - find records, column name "UserId"
    // userId - variable
}

// Repository - Dynamic Proxy - generate access code to database - runtime generator
// connect class Checkbox with Data Base - JPA gives me Save, delete, find


