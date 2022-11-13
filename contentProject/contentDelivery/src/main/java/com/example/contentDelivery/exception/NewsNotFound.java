package com.example.contentDelivery.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "News not found")
public class NewsNotFound extends Exception {

}
