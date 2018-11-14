package com.epam.service;

import com.epam.model.News;

import java.util.List;

public interface NewsService {

    boolean add(News news);

    List<News> getAll();

    News get(long id);

    void update(long id, News news);

    void delete(long id);
}
