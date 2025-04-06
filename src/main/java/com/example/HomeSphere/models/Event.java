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
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device_id;

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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Device getDevice_id() {
        return device_id;
    }

    public void setDevice_id(Device device_id) {
        this.device_id = device_id;
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
