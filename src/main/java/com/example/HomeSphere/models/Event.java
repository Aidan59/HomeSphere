package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@MappedSuperclass
public class Event {

    public Event(String event, LocalDateTime time) {
        this.event = event;
        this.time = time;
    }

    public Event() {}

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column
    private String event;

    @NotNull
    @Column
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
