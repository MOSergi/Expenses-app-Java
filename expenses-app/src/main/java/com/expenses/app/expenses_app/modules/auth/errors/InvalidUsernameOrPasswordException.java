package com.expenses.app.expenses_app.modules.auth.errors;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException(){
        super("El usuario o la contraseña no son válidos");
    }
}
