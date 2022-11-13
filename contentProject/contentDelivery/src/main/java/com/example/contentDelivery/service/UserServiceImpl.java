package com.example.contentDelivery.service;

import com.example.contentDelivery.exception.UserAlreadyExistException;
import com.example.contentDelivery.exception.UserNotFoundException;
import com.example.contentDelivery.model.Content;
import com.example.contentDelivery.model.User;
import com.example.contentDelivery.proxy.userProxy;
import com.example.contentDelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private userProxy userProxy;

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        User res= userRepository.insert(user);
        ResponseEntity<?> response=userProxy.saveUser(user); // request for other
        System.out.println("\n response : "+response);
        return res;
    }

    @Override
    public User addContentForUser(String emailid, Content content) throws UserNotFoundException {
        if(userRepository.findById(emailid).isPresent()){
            User user=userRepository.findById(emailid).get();
            user.getContentList().add(content);
            return userRepository.save(user);
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public Optional<User> getAllContent(String emailid) {
        return userRepository.findById(emailid);
    }
/*
    @Override
    public boolean delNews(int id) {
        userRepository.findById(id);
        return true;
    }*/
}
