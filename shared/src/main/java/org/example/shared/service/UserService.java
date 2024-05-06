package org.example.shared.service;

import org.example.shared.domain.User;

public interface UserService {
    void addUser(User input);

    void deleteUser(String birthNumber);

    User getUser(String birthNumber);
}
