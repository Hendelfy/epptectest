package org.example.shared.service.validation;

import org.example.shared.domain.User;
import org.example.shared.exception.ValidationException;
import org.example.shared.service.validation.rules.BirthNumberValidationRule;
import org.example.shared.service.validation.rules.ValidationRule;

import java.util.Set;

public class UserValidationImpl implements UserValidation {
    private final Set<ValidationRule> validationRules;
    private final BirthNumberValidationRule birthNumberValidationRule;

    public UserValidationImpl(Set<ValidationRule> validationRules, BirthNumberValidationRule birthNumberValidationRule) {
        this.validationRules = validationRules;
        this.birthNumberValidationRule = birthNumberValidationRule;
    }

    @Override
    public void validate(User user) {
        if (user == null) {
            throw new ValidationException("User is null");
        }
        validationRules.forEach(rule -> rule.validate(user));
    }

    @Override
    public void validateBirthNumber(String birthNumber) {
        birthNumberValidationRule.validate(birthNumber);
    }
}
