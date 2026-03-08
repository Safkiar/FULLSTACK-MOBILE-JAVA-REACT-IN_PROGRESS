package com.example.demo.repository;

import com.example.demo.entity.IncomingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EventCategory;

import java.util.UUID;
import java.util.List;

@Repository
// Create  Bean
public interface IncomingEventRepository extends JpaRepository<IncomingEvent, UUID> {
// Create an interface

    List<IncomingEvent> findByUserId(UUID userId);
    List<IncomingEvent> findByUserIdOrderByEventDateAsc(UUID userId);
    List<IncomingEvent> findByCategory(EventCategory category);
    List<IncomingEvent> findByUserIdAndCategoryOrderByEventDateAsc(UUID userId, EventCategory category);
}