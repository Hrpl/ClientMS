package com.webapi.firstapi.controller;

import com.webapi.firstapi.models.User;
import com.webapi.firstapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("api/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    User findUserByid(@PathVariable int id){ // Параметр из строки запроса
        var user = userService.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // Выводит статус код ошибки 404
        }
    }

    @PostMapping("")
    void create(@RequestBody  User user){ // Параметр из тела запроса
        userService.create(user);
    }
}
