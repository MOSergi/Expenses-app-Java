package com.expenses.app.expenses_app.modules.shared.errors;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(){
        super("Token no válido");
    }
}
