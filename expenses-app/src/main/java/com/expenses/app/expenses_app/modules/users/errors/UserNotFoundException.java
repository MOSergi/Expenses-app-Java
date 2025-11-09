package com.expenses.app.expenses_app.modules.users.errors;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
