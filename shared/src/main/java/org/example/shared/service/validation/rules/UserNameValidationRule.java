package org.example.shared.service.validation.rules;

import org.example.shared.domain.User;
import org.example.shared.exception.ValidationException;

public class UserNameValidationRule implements ValidationRule{
    @Override
    public void validate(User user) {
        String name = user.getName();
        if (name == null || name.isEmpty()) {
            throw new ValidationException("Name is empty");
        }
    }
}
