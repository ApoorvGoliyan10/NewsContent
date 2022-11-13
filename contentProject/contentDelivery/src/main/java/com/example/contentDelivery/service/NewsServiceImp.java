package com.example.contentDelivery.service;

import com.example.contentDelivery.repository.NewsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    NewsRepos nrp;
    @Override
    public boolean delNews(int newsid) {
        nrp.findById(newsid);
        return true;
    }
}
