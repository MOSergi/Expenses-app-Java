package com.expenses.app.expenses_app.modules.shared.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expenses.app.expenses_app.modules.shared.services.model.UserDetailModel;
import com.expenses.app.expenses_app.modules.users.entities.User;
import com.expenses.app.expenses_app.modules.users.repository.UsersRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.usersRepository.findByEmail(email);

        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        UserDetailModel userDetailModel = new UserDetailModel(optionalUser.orElseThrow().getEmail(), optionalUser.orElseThrow().getPassword(), optionalUser.orElseThrow().getEnable());

        return userDetailModel;
    }
}
