package com.servis.event.controller;

import com.servis.event.model.Event;
import com.servis.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> eventList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("events");
        return eventService.findAll();
    }
}
