package com.expenses.app.expenses_app.modules.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.app.expenses_app.modules.auth.dtos.LoginDto;
import com.expenses.app.expenses_app.modules.auth.service.AuthService;
import com.expenses.app.expenses_app.modules.auth.viewModels.UserAuthViewModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService; 
    
    @PostMapping("/login")
    public ResponseEntity<UserAuthViewModel> login(@Valid @RequestBody LoginDto loginDto){
        UserAuthViewModel auth = this.authService.login(loginDto);

        return ResponseEntity.status(200).body(auth);
    }
}
