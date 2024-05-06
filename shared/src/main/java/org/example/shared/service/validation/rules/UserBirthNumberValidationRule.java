package org.example.shared.service.validation.rules;

import org.example.shared.domain.User;
import org.example.shared.exception.ValidationException;

public class UserBirthNumberValidationRule implements ValidationRule {

    private final BirthNumberValidationRule birthNumberValidationRule;

    public UserBirthNumberValidationRule(BirthNumberValidationRule birthNumberValidationRule) {
        this.birthNumberValidationRule = birthNumberValidationRule;
    }

    @Override
    public void validate(User user) {
        String birthNumber = user.getBirthNumber();
        if (birthNumber == null || birthNumber.isEmpty()) {
            throw new ValidationException("Birth number is empty");
        }
        birthNumberValidationRule.validate(birthNumber);
    }
}
