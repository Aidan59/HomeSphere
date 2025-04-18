package com.example.HomeSphere.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean email_notifications;

    @Column
    private boolean telegram_notifications;

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

    public boolean isEmail_notifications() {
        return email_notifications;
    }

    public void setEmail_notifications(boolean email_notifications) {
        this.email_notifications = email_notifications;
    }

    public boolean isTelegram_notifications() {
        return telegram_notifications;
    }

    public void setTelegram_notifications(boolean telegram_notifications) {
        this.telegram_notifications = telegram_notifications;
    }
}
