package com.expenses.app.expenses_app.modules.users.errors;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(){
        super("Email inválido, introduce otro");
    }
}
