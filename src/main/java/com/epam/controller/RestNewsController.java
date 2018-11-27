package com.epam.controller;

import com.epam.model.News;
import com.epam.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/news")
public class RestNewsController {

    private NewsService newsService;

    @GetMapping
    public List getAll() {
        return newsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNews(
        @PathVariable
            long id) {
        List newsList = newsService.get(id);
        if (newsList.isEmpty()) {
            return new ResponseEntity<>("Wrong id!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Object> addNews(
        @Valid
        @RequestBody
            News news) {
        newsService.add(news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNews(
        @Valid
        @RequestBody
            News news,
        @PathVariable("id")
            long id) {
        newsService.update(id, news);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteNews(
        @PathVariable
            long id) {
        newsService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
