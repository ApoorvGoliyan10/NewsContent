package com.stackroute.jwtdemo.jwtex.service;

import com.stackroute.jwtdemo.jwtex.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String, String> generateToken(User user);

}
