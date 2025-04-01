package com.example.HomeSphere.models;

import jakarta.persistence.*;

@Entity
@Table(name = "device_events")
public class DeviceEvent extends Event {

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device_id;

}
