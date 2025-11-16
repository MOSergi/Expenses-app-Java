package com.expenses.app.expenses_app.modules.auth.viewModels;

public class UserAuthViewModel {
    private Boolean auth;
    private String token;

    public UserAuthViewModel() {}

    public UserAuthViewModel(Boolean auth, String token) {
        this.auth = auth;
        this.token = token;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
