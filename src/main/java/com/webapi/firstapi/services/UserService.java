package com.webapi.firstapi.services;

import com.webapi.firstapi.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public Optional<User> findById(int id){
        return users.stream().filter(w -> w.id() == id).findFirst();
    }

    public void create(User user){
        users.add(user);
    }

    public void update(User user, Integer id){
        Optional<User> existing = findById(id);
        if(existing.isPresent()){
            users.set(users.indexOf(existing.get()), user);
        }
    }

    public void delete(Integer id){
        users.removeIf(u -> u.id() == id);
    }

    @PostConstruct
    private void init(){
        users.add(new User( 1,
                "Andrey",
                18,
                "example@mail.ru")
        );
        users.add(new User(2,
                "Oleg",
                20,
                "Oleg@example.com")
        );
    }
}
