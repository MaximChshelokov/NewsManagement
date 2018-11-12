package com.epam.controller;

import com.epam.controller.consts.ViewConstants;
import com.epam.model.News;
import com.epam.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class NewsController {

    private static final String NEWS = "news";
    private NewsService newsService;

    @GetMapping("/add-news")
    public String drawNewsForm(News news, Model model) {
        model.addAttribute(NEWS, news);
        return ViewConstants.ADD_NEWS;
    }

    @PostMapping("/add-news")
    public String addStudent(@Valid News news,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ViewConstants.ADD_NEWS;
        newsService.add(news);
        return "forward:/view-news.do?id=" + news.getId();
    }

    @RequestMapping(value="/news-list")
    public String getNewsList(ModelMap model) {
        model.addAttribute("newsList", newsService.getAll());
        return ViewConstants.NEWS_LIST;
    }

    @GetMapping("/edit-news")
    public String editNewsForm(@RequestParam("id") long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.EDIT_NEWS;
    }

    @PostMapping("/edit-news")
    public String updateNews(@Valid News news,
                             @RequestParam("id") long id,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ViewConstants.EDIT_NEWS;
        newsService.update(id, news);
        return "forward:/view-news.do";
    }

    @RequestMapping("/view-news")
    public String viewNews(@RequestParam("id") long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.NEWS_VIEW;
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
