package com.expenses.app.expenses_app.modules.shared.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.expenses.app.expenses_app.modules.auth.errors.InvalidUsernameOrPasswordException;
import com.expenses.app.expenses_app.modules.shared.errors.InvalidTokenException;
import com.expenses.app.expenses_app.modules.shared.utils.ErrorFormater;
import com.expenses.app.expenses_app.modules.users.errors.UserAlreadyExistsException;
import com.expenses.app.expenses_app.modules.users.errors.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //Catch all
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleRuntimeException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(generateErrorFormat(500, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errors = exception.getAllErrors();

        List<String> parsedErrors = new ArrayList<>();

        errors.forEach(error -> {
            parsedErrors.add(error.getDefaultMessage());
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(generateErrorFormat(400, LocalDateTime.now(), parsedErrors.toString()));
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(generateErrorFormat(404, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(generateErrorFormat(400, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({ InvalidTokenException.class })
     public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException exception) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(generateErrorFormat(401, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({ UsernameNotFoundException.class })
     public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(generateErrorFormat(409, LocalDateTime.now(), exception.getMessage()));
    }

    @ExceptionHandler({ InvalidUsernameOrPasswordException.class })
     public ResponseEntity<Object> handleInvalidUsernamePasswordException(InvalidUsernameOrPasswordException exception) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(generateErrorFormat(401, LocalDateTime.now(), exception.getMessage()));
    }

    private ErrorFormater generateErrorFormat(Integer code, LocalDateTime timestamp, String message){
        ErrorFormater errorFormater = new ErrorFormater();

        errorFormater.setCode(code);
        errorFormater.setTimestamp(timestamp);
        errorFormater.setMessage(message);

        return errorFormater;
    }
}
