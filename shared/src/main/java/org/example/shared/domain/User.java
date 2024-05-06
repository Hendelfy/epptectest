package org.example.shared.domain;

public class User {
    private final String name;
    private final String surname;
    private final String birthNumber;

    public User(String name, String surname, String birthNumber) {
        this.name = name;
        this.surname = surname;
        this.birthNumber = birthNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthNumber() {
        return birthNumber;
    }
}
