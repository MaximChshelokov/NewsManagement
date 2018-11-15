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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class NewsController {

    private static final String NEWS = "news";
    private static final String REDIRECT_VIEW_NEWS = "redirect:/view-news";
    private static final String REDIRECT_NEWS_LIST = "redirect:/news-list";
    public static final String ID = "id";
    private NewsService newsService;

    @GetMapping("/add-news")
    public String drawNewsForm(News news, Model model) {
        model.addAttribute(NEWS, news);
        return ViewConstants.ADD_NEWS;
    }

    @PostMapping("/add-news")
    public String addStudent(@Valid News news, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors())
            return ViewConstants.ADD_NEWS;
        newsService.add(news);
        redirectAttributes.addAttribute(ID, news.getId());
        return REDIRECT_VIEW_NEWS;
    }

    @RequestMapping("/news-list")
    public String getNewsList(ModelMap model) {
        model.addAttribute("newsList", newsService.getAll());
        return ViewConstants.NEWS_LIST;
    }

    @GetMapping("/edit-news/{id}")
    public String editNewsForm(@PathVariable(ID) long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.EDIT_NEWS;
    }

    @PostMapping("/edit-news/{id}")
    public String updateNews(@Valid News news, BindingResult bindingResult, @PathVariable(ID) long id,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors())
            return ViewConstants.EDIT_NEWS;
        newsService.update(id, news);
        redirectAttributes.addAttribute(ID, news.getId());
        return REDIRECT_VIEW_NEWS;
    }

    @RequestMapping("/view-news/{id}")
    public String viewNews(@PathVariable(ID) long id, Model model) {
        model.addAttribute(NEWS, newsService.get(id));
        return ViewConstants.NEWS_VIEW;
    }

    @RequestMapping("/delete-news/{id}")
    public String deleteNews(@PathVariable(ID) long id) {
        newsService.delete(id);
        return REDIRECT_NEWS_LIST;
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
