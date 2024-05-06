package org.example.shared.service.impl;

import org.example.shared.domain.User;
import org.example.shared.service.UserExtractor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserExtractorImpl implements UserExtractor {

    private static final int WOMEN_BIRTH_NUMBER_ADDS_TO_MONTH = 50;

    @Override
    public User getUser(User user) {
        return new User(user.getName(), user.getSurname(), normalizeBirthNumber(user.getBirthNumber()));
    }

    @Override
    public String normalizeBirthNumber(String birthNumber) {
        return birthNumber.replace("/", "");
    }

    @Override
    public long getUserAge(User user) {
        String birthNumber = user.getBirthNumber();
        LocalDate now = LocalDate.now();

        int year = Integer.parseInt(birthNumber.substring(0, 2));
        year += year > now.getYear() % 100 ? 1900 : 2000;
        int month = Integer.parseInt(birthNumber.substring(2, 4));
        if (month > 12) {
            month = month - WOMEN_BIRTH_NUMBER_ADDS_TO_MONTH;
        }
        int day = Integer.parseInt(birthNumber.substring(4, 6));

        return ChronoUnit.YEARS.between(LocalDate.of(year, month, day), now);
    }
}
