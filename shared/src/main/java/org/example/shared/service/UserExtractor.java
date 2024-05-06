package org.example.shared.service;

import org.example.shared.domain.User;

public interface UserExtractor {
    User getUser(User user);

    String normalizeBirthNumber(String birthNumber);

    long getUserAge(User user);
}
