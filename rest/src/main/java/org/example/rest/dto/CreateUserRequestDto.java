package org.example.rest.dto;

public class CreateUserRequestDto {
    private String name;
    private String surname;
    private String birthNumber;

    public String getName() {
        return name;
    }

    public CreateUserRequestDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public CreateUserRequestDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public CreateUserRequestDto setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
        return this;
    }
}
