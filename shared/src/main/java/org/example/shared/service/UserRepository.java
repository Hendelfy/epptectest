package org.example.shared.service;

import org.example.shared.domain.User;

public interface UserRepository {
    void addUser(User user);

    void deleteUser(String birthNumber);

    User getUser(String birthNumber);
}
