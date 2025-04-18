package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "events")
public class Event {

    public Event() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @Column
    @NotNull
    private String event;

    @Column
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
