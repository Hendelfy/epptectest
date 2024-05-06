package org.example.shared.service.validation.rules;

import org.example.shared.domain.User;
import org.example.shared.exception.ValidationException;

public class UserSurnameValidationRule implements ValidationRule {
    @Override
    public void validate(User user) {
        String surname = user.getSurname();
        if (surname == null || surname.isEmpty()) {
            throw new ValidationException("Surname is empty");
        }
    }
}
