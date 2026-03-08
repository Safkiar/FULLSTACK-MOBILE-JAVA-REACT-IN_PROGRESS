package com.example.demo.entity;
// file address

import jakarta.persistence.*;
// import all * - connect do DataBase
// Lombok - method writing library
import lombok.Getter;
// get data
import lombok.Setter;
// set data
import lombok.NoArgsConstructor;
// blank formula - no arguments constructor
import org.hibernate.annotations.CreationTimestamp;
// hibernate - translate java to SQL
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
// what format our java should use
import java.util.UUID;
// universally unique identifier - string generator

@Entity
// Entity - save it on disc
@Table(name = "r1_checkboxes")
// Insert all object from here into this table
@Getter
// Generate
@Setter
// Generate
@NoArgsConstructor
// Blank page, insert later data from DataBase

public class Checkbox {
    // everyone can use it - public
    // class - definition of schema
    @Id
    // Primary Key
    @GeneratedValue(strategy = GenerationType.UUID)
    //  DataBase should generate value with this strategy
    @Column(name = "chk_id", updatable = false, nullable = false)
    // database name, no updates, cannot be null
    private UUID id;
    // private type name

    @Column(name = "chk_title", length = 255, nullable = false)
    private String title;

    @Column(name = "chk_text", length = 500, nullable = false)
    private String text;

    @Column(name = "chk_mark", nullable = false)
    private boolean mark;

    @CreationTimestamp
    @Column(name = "chk_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "chk_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "chk_user_id")
    private UUID userId;

    @Version
    // Optimistic locking - last update
    @Column(name = "chk_version", nullable = false)
    private Integer version;
}
