package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "device_events")
public class DeviceEvent extends Event {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device_id;

    public DeviceEvent(String event, LocalDateTime time) {
        super(event, time);
    }

    public DeviceEvent() {

    }
}
