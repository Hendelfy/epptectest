package org.example.shared.service.validation;

import org.example.shared.domain.User;

public interface UserValidation {
    void validate(User user);

    void validateBirthNumber(String birthNumber);
}
