package com.webapi.firstapi.services;

import com.webapi.firstapi.models.Users;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository

public class UserService {
    private final JdbcClient jdbcClient;

    public UserService(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Users> findAll(){
        return jdbcClient.sql("select * from users").query(Users.class).list();
    }

    public Users login(String email, String password) throws Exception { // обозначение того, что метод может выкидывать исключения
        String requestStingSql = String.format("select * from users where login = '%s' and password = '%s'", email, password);
        try {
            return jdbcClient.sql(requestStingSql).query(Users.class).single();
        }
        catch (Exception e){

            throw new Exception(); // выкидывает общий класс для всех исключений
        }
    }

}
