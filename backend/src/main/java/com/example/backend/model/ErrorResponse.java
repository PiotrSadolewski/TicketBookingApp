package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;
    private String status;
    private int code;
    private List<String> errors;

    public ErrorResponse(HttpStatus status, String message) {
        this.status = status.name();
        this.message = message;
        this.code = status.value();
        this.timestamp = new Date();
    }

    public ErrorResponse(String message, List<String> errors, HttpStatus status) {
            this.message = message;
            this.errors = errors;
            this.timestamp = new Date();
            this.status = status.name();
            this.code = status.value();
    }
}


