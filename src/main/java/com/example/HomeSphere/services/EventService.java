package com.example.HomeSphere.services;

import com.example.HomeSphere.models.*;
import com.example.HomeSphere.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    private EventRepository EventRepository;
    private UserDetailsService userDetailsService;

    public EventService(EventRepository EventRepository, EventRepository eventRepository, UserDetailsService userDetailsService) {
        this.eventRepository = EventRepository;
        this.eventRepository = eventRepository;
        this.userDetailsService = userDetailsService;
    }

    public List<Event> getTopEvents() {
        return eventRepository.findTop10EventsByUser(userDetailsService.getCurrentUser());
    }

    public List<Event> getEventsPage(int page){
        return eventRepository.findAllByOrderByTimeDesc(PageRequest.of(page - 1, 10)).getContent();
    }

    public int getCountOfPages(){
        return Math.round((float) eventRepository.countByUser(userDetailsService.getCurrentUser()) / 10);
    }

}
