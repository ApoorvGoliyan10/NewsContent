package com.stackroute.jwtdemo.jwtex.repository;

import com.stackroute.jwtdemo.jwtex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    public User findByEmailidAndPassword(String emailid, String password);
}
