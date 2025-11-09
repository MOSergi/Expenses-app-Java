package com.expenses.app.expenses_app.modules.shared.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.expenses.app.expenses_app.modules.shared.utils.ErrorFormater;
import com.expenses.app.expenses_app.modules.users.errors.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(generateErrorFormat(500, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(generateErrorFormat(404, LocalDateTime.now(), exception.getMessage()));
    }

    private ErrorFormater generateErrorFormat(Integer code, LocalDateTime timestamp, String message){
        ErrorFormater errorFormater = new ErrorFormater();

        errorFormater.setCode(code);
        errorFormater.setTimestamp(timestamp);
        errorFormater.setMessage(message);

        return errorFormater;
    }
}
