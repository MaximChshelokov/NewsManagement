package com.epam.service;


import com.epam.dao.NewsDao;
import com.epam.model.News;
import com.epam.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsServiceImpl")
public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao;

    @Override
    public boolean add(News news) {
        return newsDao.save(news) != 0;
    }

    @Override
    public List<News> getAll() {
        return newsDao.getAll();
    }

    @Override
    public News get(long id) {
        return newsDao.get(id);
    }

    @Override
    public void update(long id, News news) {
        newsDao.update(id, news) ;
    }

    @Autowired
    public void setRepository(NewsDao newsDao) {
        this.newsDao = newsDao;
    }
}
