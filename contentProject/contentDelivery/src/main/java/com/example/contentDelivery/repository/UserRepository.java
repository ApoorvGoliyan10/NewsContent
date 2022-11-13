package com.example.contentDelivery.repository;

import com.example.contentDelivery.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

}
