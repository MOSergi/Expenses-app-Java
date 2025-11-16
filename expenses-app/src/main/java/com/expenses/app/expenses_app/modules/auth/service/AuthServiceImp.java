package com.expenses.app.expenses_app.modules.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.expenses.app.expenses_app.modules.auth.dtos.LoginDto;
import com.expenses.app.expenses_app.modules.auth.errors.InvalidUsernameOrPasswordException;
import com.expenses.app.expenses_app.modules.auth.viewModels.UserAuthViewModel;
import com.expenses.app.expenses_app.modules.shared.utils.JwtUtil;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserAuthViewModel login(LoginDto body) {
        
        try {
            this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword())
            );
        } catch (AuthenticationException exception){
            throw new InvalidUsernameOrPasswordException();
        }

        String token = this.jwtUtil.generateToken(body.getEmail());

        UserAuthViewModel userAuthViewModel = new UserAuthViewModel(true, token);

        return userAuthViewModel;
    }
}
