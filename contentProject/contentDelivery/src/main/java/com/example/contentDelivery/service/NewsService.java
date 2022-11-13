package com.example.contentDelivery.service;
import com.example.contentDelivery.exception.NewsNotFound;

public interface NewsService {
    public boolean delNews(int newsid) throws NewsNotFound;
}
