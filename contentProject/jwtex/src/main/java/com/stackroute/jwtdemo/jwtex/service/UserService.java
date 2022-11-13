package com.stackroute.jwtdemo.jwtex.service;

import com.stackroute.jwtdemo.jwtex.exceptions.UserNotFoundException;
import com.stackroute.jwtdemo.jwtex.model.User;

import java.util.List;

public interface UserService {
    public abstract User saveUser(User user);
   // public abstract User authenticateUser(int uid,String pwd) throws UserNotFoundException;
    public abstract User authenticateUser(String emailid,String pwd) throws UserNotFoundException;
  /*  User authenticateUser(String emailid, String password);*/

    public abstract List<User> getAllUsers();

}
