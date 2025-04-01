package com.example.HomeSphere.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_events")
public class UserEvent extends Event {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

}
