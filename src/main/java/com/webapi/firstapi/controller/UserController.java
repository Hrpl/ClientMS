package com.webapi.firstapi.controller;

import com.webapi.firstapi.models.User;
import com.webapi.firstapi.services.UserService;
import jakarta.validation.Valid;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("login/{login}/{password}")
    User login(@PathVariable String login, @PathVariable String password){
        try {
            return userService.login(login, password);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"); // исключение статус кода, хз почему не надо указывать throw
        }
    }

//    @GetMapping("/{id}")
//    User findUserByid(@PathVariable int id){ // Параметр из строки запроса
//        var user = userService.findById(id);
//        if(user.isPresent()){
//            return user.get();
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"); // Выводит статус код ошибки 404
//        }
//    }

//    @ResponseStatus(HttpStatus.CREATED) // Вернёт статус 201
//    @PostMapping("")
//    void create(@Valid @RequestBody User user){ // Параметр из тела запроса
//        userService.create(user);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("{id}")
//    void update(@Valid @RequestBody User user, @PathVariable Integer id){
//        userService.update(user, id);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("{id}")
//    void delete(@PathVariable Integer id){
//        userService.delete(id);
//    }
}
