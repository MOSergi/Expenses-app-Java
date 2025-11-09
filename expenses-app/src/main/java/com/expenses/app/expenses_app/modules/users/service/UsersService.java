package com.expenses.app.expenses_app.modules.users.service;

import java.util.List;

import com.expenses.app.expenses_app.modules.users.viewModels.UserViewModel;

public interface UsersService {
    public List<UserViewModel> listAll();

    public UserViewModel getById(Long id);
}
