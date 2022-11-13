package com.example.contentDelivery.repository;

import com.example.contentDelivery.model.Content;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepos  extends MongoRepository<Content,Integer>{

}
