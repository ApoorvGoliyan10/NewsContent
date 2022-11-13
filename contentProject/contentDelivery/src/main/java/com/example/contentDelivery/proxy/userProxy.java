package com.example.contentDelivery.proxy;


import com.example.contentDelivery.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//  http://localhost:64200/userservice/register [post]

@FeignClient(name="jwtex-service",url="localhost:64200")
public interface userProxy {

    @PostMapping("/userservice/register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
