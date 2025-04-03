package com.example.HomeSphere.services;

import com.example.HomeSphere.models.*;
import com.example.HomeSphere.repositories.DeviceEventRepository;
import com.example.HomeSphere.repositories.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private UserEventRepository userEventRepository;
    private DeviceEventRepository deviceEventRepository;
    private UserDetailsService userDetailsService;

    public EventService(UserEventRepository userEventRepository, DeviceEventRepository deviceEventRepository, UserDetailsService userDetailsService) {
        this.userEventRepository = userEventRepository;
        this.deviceEventRepository = deviceEventRepository;
        this.userDetailsService = userDetailsService;
    }

    public List<Event> getAllEvents() {
        User currentUser = userDetailsService.getCurrentUser();
        List<Event> events = new ArrayList<>();

        Collections.addAll(events, currentUser.getUserEventList().toArray(new UserEvent[0]));
        for (Device d: currentUser.getDeviceList()) {
            Collections.addAll(events, d.getDeviceEventsList().toArray(new DeviceEvent[0]));
        }

        Collections.sort(events, (e1, e2) -> e2.getTime().compareTo(e1.getTime()));

        return events;
    }
}
