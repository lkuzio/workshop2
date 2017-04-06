package com.pgs.dto;

/**
 * Created by Luke on 2017-04-06.
 */
public class ErrorDTO {

    private String message;
    private String details;

    public ErrorDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
