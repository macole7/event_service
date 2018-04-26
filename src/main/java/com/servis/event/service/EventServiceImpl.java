package com.servis.event.service;

import com.servis.event.model.Event;
import com.servis.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();

    }

    @Override
    public Optional<Event> findById(Integer id) {
        Optional<Event> byId = eventRepository.findById(id);
        byId.orElseThrow(() -> new RuntimeException("There is not such event"));
        return byId;
    }

    @Override
    public List<Event> findByName(String name) {
        Optional<List<Event>> listOptional = Optional.ofNullable(eventRepository.findByName(name));
        return listOptional.orElseThrow(() -> new RuntimeException("There is not such event"));
    }
}
