package com.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime dateTime;
    private String message;
    private String description;
    private String errors = "";

    public ErrorDetail(LocalDateTime dateTime, String message, String description) {
        this.dateTime = dateTime;
        this.message = message;
        this.description = description;
    }

    public ErrorDetail(LocalDateTime dateTime, String message, String description, String errors) {
        this.dateTime = dateTime;
        this.message = message;
        this.description = description;
        this.errors = errors;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
