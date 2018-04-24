package com.servis.event.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime date;

    private String name;

    private String address;

    private Access access;

    @OneToMany
    private Set<User> organizers;


    public Event(LocalDateTime date, String name, String address, Access access, Set<User> organizers) {
        this.date = date;
        this.name = name;
        this.address = address;
        this.access = access;
        this.organizers = organizers;
    }

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Access getAccess() {
        return access;
    }

    public Set<User> getOrganizers() {
        return organizers;
    }
}
