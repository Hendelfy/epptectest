package org.example.rest.dto;

public class ExceptionDto {
    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
