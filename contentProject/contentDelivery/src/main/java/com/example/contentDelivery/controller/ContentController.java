package com.example.contentDelivery.controller;

import com.example.contentDelivery.exception.NewsNotFound;
import com.example.contentDelivery.exception.UserAlreadyExistException;
import com.example.contentDelivery.exception.UserNotFoundException;
import com.example.contentDelivery.model.Content;
import com.example.contentDelivery.model.User;
import com.example.contentDelivery.service.UserService;
import com.example.contentDelivery.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
// @CrossOrigin("*")
@RequestMapping("usercontent")
public class ContentController
{
    @Autowired
    private UserService userService;
   @Autowired
    private NewsService ns;

    // http://localhost:64100/usercontent/register   [post]

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistException{
        try{
            user.setContentList(new ArrayList<>());
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        }
        catch (Exception ex){
            throw new UserAlreadyExistException();
        }
    }

    // http://localhost:64100/usercontent/add/emailid    [put]

    @PutMapping("/add/{emailid}")
    public ResponseEntity<?> addContentToUser(@PathVariable String emailid, @RequestBody Content content) throws UserNotFoundException{
        try{
            return new ResponseEntity<>(userService.addContentForUser(emailid, content),HttpStatus.OK);
        }
        catch (Exception e){
            throw new UserNotFoundException();
        }
    }

    // http://localhost:64100/usercontent/get/emailid    [get]

    @GetMapping("/get/{emailid}")
    public ResponseEntity<?> getAllContent(@PathVariable String emailid){
        return new ResponseEntity<>(userService.getAllContent(emailid),HttpStatus.OK);
    }

    // http://localhost:64100/usercontent/delete/newsid [delete]
    @DeleteMapping("/delete/{newsid}")
    public ResponseEntity<?> deleteNews(@PathVariable int newsid) throws NewsNotFound {
        return new ResponseEntity<>(ns.delNews(newsid),HttpStatus.OK);
    }
}
