package com.stackroute.jwtdemo.jwtex.controller;

import com.stackroute.jwtdemo.jwtex.exceptions.UserNotFoundException;
import com.stackroute.jwtdemo.jwtex.model.User;
import com.stackroute.jwtdemo.jwtex.service.SecurityTokenGenerator;
import com.stackroute.jwtdemo.jwtex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/userservice")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    // http://localhost:64200/userservice/register   [post]
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // http://localhost:64200/userservice/login   [post]
    @PostMapping("/login")
    public ResponseEntity<?> logincheck(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map = null;
        User res=userService.authenticateUser(user.getEmailid(),user.getPassword());
        if(res!=null)
        {
            map=securityTokenGenerator.generateToken(res);
            return new ResponseEntity(map,HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(new String("login Failed"),HttpStatus.OK);
        }
    }


    @GetMapping("/getallusers")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }





}
