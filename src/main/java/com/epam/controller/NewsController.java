package com.epam.controller;

import com.epam.controller.consts.ViewConstants;
import com.epam.model.News;
import com.epam.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class NewsController {

    private static final String NEWS = "news";
    private static final String REDIRECT_VIEW_NEWS = "redirect:/view-news";
    private static final String REDIRECT_NEWS_LIST = "redirect:/news-list";
    public static final String ANGULAR_REST = "rest-angular";
    private NewsService newsService;

    @RequestMapping("/")
    public String redirectToNewsList() {
        return ANGULAR_REST;
    }

    @GetMapping("/add-news")
    public String drawNewsForm(News news, Model model) {
        model.addAttribute(NEWS, news);
        return ViewConstants.ADD_NEWS;
    }

    @PostMapping("/add-news")
    public String addStudent(
        @Valid
            News news, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ViewConstants.ADD_NEWS;
        }
        newsService.add(news);
        return REDIRECT_VIEW_NEWS + '/' + news.getId();
    }

    @RequestMapping("/news-list")
    public String getNewsList(ModelMap model) {
        model.addAttribute("newsList", newsService.getAll());
        return ViewConstants.NEWS_LIST;
    }

    @GetMapping("/edit-news/{id}")
    public String editNewsForm(
        @PathVariable("id")
            long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.EDIT_NEWS;
    }

    @PostMapping("/edit-news/{id}")
    public String updateNews(
        @Valid
            News news, BindingResult bindingResult,
        @PathVariable("id")
            long id) {
        if (bindingResult.hasErrors()) {
            return ViewConstants.EDIT_NEWS;
        }
        newsService.update(id, news);
        return REDIRECT_VIEW_NEWS + '/' + news.getId();
    }

    @RequestMapping("/view-news/{id}")
    public String viewNews(
        @PathVariable("id")
            long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.NEWS_VIEW;
    }

    @RequestMapping("/delete-news/{id}")
    public String deleteNews(
        @PathVariable("id")
            long id) {
        newsService.delete(id);
        return REDIRECT_NEWS_LIST;
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
