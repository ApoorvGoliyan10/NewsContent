package com.stackroute.jwtdemo.jwtex.service;

import com.stackroute.jwtdemo.jwtex.model.User;
import com.stackroute.jwtdemo.jwtex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String emailid, String password)  {
        User user=userRepository.findByEmailidAndPassword(emailid,password);
        if(user==null){
            throw new RuntimeException();

        }
        System.out.println("user is"+user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
