package com.servis.event.service;

import com.servis.event.model.User;

public interface UserService {
    User findByEmail(String email);

    void save(User user);


}
