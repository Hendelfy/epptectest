package org.example.shared.service.validation.rules;

import org.example.shared.exception.ValidationException;

import java.util.regex.Pattern;

public class BirthNumberValidationRule {
    private static final Pattern birthNumberPattern = Pattern.compile("^(\\d{2})(0[1-9]|[1-5]\\d|6[0-2])(0[1-9]|[12]\\d|3[01])/?\\d{4}$");

    public void validate(String birthNumber) {
        if (!birthNumberPattern.matcher(birthNumber).matches()) {
            throw new ValidationException("Birth number format is invalid");
        }
    }
}
