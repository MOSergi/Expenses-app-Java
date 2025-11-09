package com.expenses.app.expenses_app.modules.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.app.expenses_app.modules.shared.mappers.UserMapper;
import com.expenses.app.expenses_app.modules.users.entities.User;
import com.expenses.app.expenses_app.modules.users.errors.UserNotFoundException;
import com.expenses.app.expenses_app.modules.users.repository.UsersRepository;
import com.expenses.app.expenses_app.modules.users.viewModels.UserViewModel;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserViewModel> listAll(){
        List<User> databaseUsers = this.usersRepository.findAll();

        List<UserViewModel> parsedUsers = new ArrayList<>();

        databaseUsers.forEach(user -> {
            UserViewModel userViewModel = UserMapper.fromDatabaseToViewModel(user);

            parsedUsers.add(userViewModel);
        });

        return parsedUsers;
    }

    @Override
    public UserViewModel getById(Long id) {
        Optional<User> optionalUser = this.usersRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new UserNotFoundException("El usuario con el id " + id + " no se encontró");
        }

        UserViewModel parsedUser = UserMapper.fromDatabaseToViewModel(optionalUser.orElseThrow());

        return parsedUser;
    }
}
