package com.servis.event.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Integer id;

    @OneToOne
    private Event event;

    @OneToMany
    private Set<User> users;

    private boolean organizerApproval;

    private boolean userApproval;

    public Participation() {
    }

    public Participation(Event event, Set<User> users) {
        this.event = event;
        this.users = users;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getId() {
        return id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public boolean isOrganizerApproval() {
        return organizerApproval;
    }

    public boolean isUserApproval() {
        return userApproval;
    }
}
