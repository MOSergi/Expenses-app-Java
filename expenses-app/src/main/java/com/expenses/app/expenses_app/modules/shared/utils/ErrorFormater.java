package com.expenses.app.expenses_app.modules.shared.utils;

import java.time.LocalDateTime;

public class ErrorFormater {
    private Integer code;
    private String message;
    private LocalDateTime timestamp;

    public ErrorFormater() {}

    public ErrorFormater(Integer code, String message, LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
