package com.example.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
