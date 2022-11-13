package com.example.contentDelivery.service;

import com.example.contentDelivery.exception.UserAlreadyExistException;
import com.example.contentDelivery.exception.UserNotFoundException;
import com.example.contentDelivery.model.Content;
import com.example.contentDelivery.model.User;

import java.util.Optional;

public interface UserService
{


     public User addUser(User user) throws UserAlreadyExistException;
    public User addContentForUser(String emailid, Content content) throws UserNotFoundException;
    public Optional<User> getAllContent(String emailid);
    //public boolean delNews(int id);
}
