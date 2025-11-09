package com.expenses.app.expenses_app.modules.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.app.expenses_app.modules.users.entities.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}
