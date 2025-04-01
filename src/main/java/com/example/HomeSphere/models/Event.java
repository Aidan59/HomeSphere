package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@MappedSuperclass
public class Event {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100)
    @Column
    private String event;

    @NotEmpty
    @Column
    private LocalDateTime timeStamp;
}
