package com.epam.service;


import com.epam.model.News;
import com.epam.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsServiceImpl")
public class NewsServiceImpl {
    @Autowired
    private NewsRepository newsRepository;

    public boolean addNews(News news) {
        return newsRepository.save(news) != null;
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }
}
