package com.example.HomeSphere.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2)
    @Column
    private String login;

    @NotEmpty
    @Size(min = 2)
    @Column
    private String password;

    @Size(min = 2)
    private String fullname;

    @NotEmpty
    @Size(min = 2)
    @Email
    @Column
    private String email;

    @OneToMany(mappedBy = "user_id")
    private List<Device> deviceList;

    @OneToMany(mappedBy = "user_id")
    private List<Event> userEventList;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public List<Event> getUserEventList() {
        return userEventList;
    }

    public void setUserEventList(List<Event> userEventList) {
        this.userEventList = userEventList;
    }
}
