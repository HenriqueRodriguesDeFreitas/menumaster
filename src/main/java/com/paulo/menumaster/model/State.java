package com.paulo.menumaster.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, length = 100, nullable = false)
    private String name;

    public State() {
    }

    public State(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
