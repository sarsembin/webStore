package com.store.webStore.service;

import com.store.webStore.entity.User;

public interface UserService {
    void save(User user, String role);

    User findByUsername(String username);
}
