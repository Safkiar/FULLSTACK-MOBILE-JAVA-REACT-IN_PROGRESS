package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "r1_incomingevents")
@Getter
@Setter
@NoArgsConstructor

public class IncomingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ine_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ine_title", length = 255, nullable = false)
    private String title;

    @Column(name = "ine_text", length = 500)
    private String text;

    @Column(name = "ine_date", nullable = false)
    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ine_category", nullable = false)
    private EventCategory category = EventCategory.OTHER;

    @CreationTimestamp
    @Column(name = "ine_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "ine_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "ine_user_id")
    private UUID userId;

    @Version
    @Column(name = "ine_version", nullable = false)
    private Integer version;


}
