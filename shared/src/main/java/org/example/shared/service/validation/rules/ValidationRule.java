package org.example.shared.service.validation.rules;

import org.example.shared.domain.User;

public interface ValidationRule {
    void validate(User user);
}
