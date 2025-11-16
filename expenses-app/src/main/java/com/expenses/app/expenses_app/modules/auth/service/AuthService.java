package com.expenses.app.expenses_app.modules.auth.service;

import com.expenses.app.expenses_app.modules.auth.dtos.LoginDto;
import com.expenses.app.expenses_app.modules.auth.viewModels.UserAuthViewModel;

public interface AuthService {
    public UserAuthViewModel login(LoginDto body);
}
