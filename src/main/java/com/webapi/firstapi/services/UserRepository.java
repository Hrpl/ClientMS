package com.webapi.firstapi.services;

import com.webapi.firstapi.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
