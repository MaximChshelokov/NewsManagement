package com.epam.service;


import com.epam.dao.NewsDao;
import com.epam.model.News;
import com.epam.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsServiceImpl")
public class NewsServiceImpl {

    private NewsDao newsDao;

    public boolean add(News news) {
        return newsDao.save(news) != 0;
    }

    public List<News> getAll() {
        return newsDao.getAll();
    }

    @Autowired
    public void setRepository(NewsDao newsDao) {
        this.newsDao = newsDao;
    }
}
