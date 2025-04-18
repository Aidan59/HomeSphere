package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotEmpty
    @Size(min = 2, max = 50)
    @Column
    private String ip;

    @NotEmpty
    @Size(min = 2, max = 50)
    @Column
    private String name;

    @OneToOne
    private Group group;

    @OneToMany(mappedBy = "device")
    private List<Event> deviceEventsList;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type", columnDefinition = "device_type")
    private DeviceType deviceType;


    public Device() {
    }

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getDeviceEventsList() {
        return deviceEventsList;
    }

    public void setDeviceEventsList(List<Event> deviceEventsList) {
        this.deviceEventsList = deviceEventsList;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
