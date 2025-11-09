package com.expenses.app.expenses_app.modules.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.app.expenses_app.modules.users.service.UsersService;
import com.expenses.app.expenses_app.modules.users.viewModels.UserViewModel;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UserViewModel>> getAllUsers(){
        return ResponseEntity.status(200).body(this.usersService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserViewModel> getUserById(@PathVariable String id){
        return ResponseEntity.status(200).body(this.usersService.getById(Long.valueOf(id)));
    }
}
