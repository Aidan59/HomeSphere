package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_events")
public class UserEvent extends Event {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    public UserEvent(User user, String event, LocalDateTime time) {
        super(event, time);
        this.user_id = user;
    }

    public UserEvent() {

    }
}
