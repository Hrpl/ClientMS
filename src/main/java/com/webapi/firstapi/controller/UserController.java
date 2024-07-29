package com.webapi.firstapi.controller;

import com.webapi.firstapi.models.Users;
import com.webapi.firstapi.services.UserRepository;
import com.webapi.firstapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/users/")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping()
    List<Users> findAll(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("login/{login}/{password}")
    Users login(@PathVariable String login, @PathVariable String password){
        try {
            return userService.login(login, password);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"); // исключение статус кода, хз почему не надо указывать throw
        }
    }

    @ResponseStatus(HttpStatus.CREATED)//  Вернёт статус 201
    @CrossOrigin(origins = "*")
    @PostMapping("create/")
    void createUser(@RequestBody Users user){ // Параметр из тела запроса
       userRepository.save(user);
    }

//    @GetMapping("/{id}")
//    User findUserByid(@PathVariable int id){ // Параметр из строки запроса
//        var user = userService.findById(id );
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
