package com.webapi.firstapi.services;

import com.webapi.firstapi.interfaces.UserInterface;
import com.webapi.firstapi.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository

public class UserService implements UserInterface {
    private final JdbcClient jdbcClient;

    public UserService(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<User> findAll(){
        return jdbcClient.sql("select * from users").query(User.class).list();
    }


    public User login(String email, String password) throws Exception { // обозначение того, что метод может выкидывать исключения
        String requestStingSql = String.format("select * from users where email = '%s' and password = '%s'", email, password);
        try {
            return jdbcClient.sql(requestStingSql).query(User.class).single();
        }
        catch (Exception e){
            throw new Exception(); // выкидывает общий класс для всех исключений
        }
    }

}
