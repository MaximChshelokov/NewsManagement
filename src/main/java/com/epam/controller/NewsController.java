package com.epam.controller;

import com.epam.controller.consts.ViewConstants;
import com.epam.model.News;
import com.epam.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class NewsController {

    private NewsServiceImpl newsService;

    @GetMapping("/add-news-form")
    public String drawNewsForm(News news, Model model) {
        model.addAttribute("news", news);
        return ViewConstants.ADD_NEWS;
    }

    @PostMapping("/add-news")
    public String addStudent(@Valid News news,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return ViewConstants.ADD_NEWS;
        model.addAttribute("news", news);
        newsService.add(news);
        return ViewConstants.NEWS_VIEW;
    }

    @RequestMapping(value="/news-list")
    public String getNewsList(ModelMap model) {
        model.addAttribute("newsList", newsService.getAll());
        return ViewConstants.NEWS_LIST;
    }

    @Autowired
    public void setNewsService(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }
}
