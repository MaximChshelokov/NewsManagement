package com.epam.controller;

import com.epam.model.News;
import com.epam.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity getNews(
        @PathVariable
            long id) {
        News news = newsService.get(id);
        if (news == null) {
            return new ResponseEntity("Wrong id!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(news, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity addNews(
        @Valid
            News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult, HttpStatus.NOT_ACCEPTABLE);
        }
        newsService.add(news);
        return new ResponseEntity(news, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNews(
        @PathVariable
            long id) {
        newsService.delete(id);
        return new ResponseEntity(new Long(id), HttpStatus.OK);
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
