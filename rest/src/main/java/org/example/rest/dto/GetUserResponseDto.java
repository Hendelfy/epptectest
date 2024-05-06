package org.example.rest.dto;

public class GetUserResponseDto {
    private String name;
    private String surname;
    private String birthNumber;
    private long age;

    public GetUserResponseDto(String name, String surname, String birthNumber, long age) {
        this.name = name;
        this.surname = surname;
        this.birthNumber = birthNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public GetUserResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public GetUserResponseDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getBirthNumber() {
        return birthNumber;
    }

    public GetUserResponseDto setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
        return this;
    }

    public long getAge() {
        return age;
    }

    public GetUserResponseDto setAge(long age) {
        this.age = age;
        return this;
    }
}
