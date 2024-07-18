package com.webapi.firstapi.interfaces;

import com.webapi.firstapi.models.User;

import java.util.List;
import java.util.Optional;

public interface UserInterface {

    public List<User> findAll();

    public User login(String email, String password) throws Exception;
}
