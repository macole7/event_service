package com.servis.event.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Event event;
    @ManyToOne
    private User user;
    private String contents;

    public Comment() {
    }

    public Comment(Event event, User user, String contents) {
        this.event = event;
        this.user = user;
        this.contents = contents;
    }

    public Event getEvent() {
        return event;
    }

    public User getUser() {
        return user;
    }

    public String getContents() {
        return contents;
    }

    public Integer getId() {
        return id;
    }
}
