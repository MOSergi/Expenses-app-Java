package com.expenses.app.expenses_app.modules.shared.mappers;

import com.expenses.app.expenses_app.modules.users.dtos.UserDto;
import com.expenses.app.expenses_app.modules.users.entities.User;
import com.expenses.app.expenses_app.modules.users.viewModels.UserViewModel;

public class UserMapper {
    public static UserViewModel fromDatabaseToViewModel(User user){
        return new UserViewModel(user.getId(), user.getEmail(), user.getName());
    }

    public static User fromDtoToentity(UserDto userDto){
        User user = new User();
       
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEnable(true);

        return user;
    }
}
