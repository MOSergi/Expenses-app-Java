package com.expenses.app.expenses_app.modules.shared.mappers;

import com.expenses.app.expenses_app.modules.users.entities.User;
import com.expenses.app.expenses_app.modules.users.viewModels.UserViewModel;

public class UserMapper {
    public static UserViewModel fromDatabaseToViewModel(User user){
        return new UserViewModel(user.getId(), user.getEmail(), user.getName());
    }
}
