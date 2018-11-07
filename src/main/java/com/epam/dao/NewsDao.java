package com.epam.dao;

import com.epam.model.News;

import java.util.List;

public interface NewsDao {
    long save(News news);
    News get(long id);
    List<News> getAll();
    void update(long id, News news);
    void delete(long id);
}
