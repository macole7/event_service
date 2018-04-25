package com.servis.event.service;

import com.servis.event.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(Integer id);

    List<Event> findByName(String name);
}
