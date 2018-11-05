package com.epam.controller;

import com.epam.controller.consts.ViewConstants;
import com.epam.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddNewsController {

    @RequestMapping(value="/add-news-form", method=RequestMethod.GET)
    public ModelAndView drawNewsForm() {
        return new ModelAndView(ViewConstants.ADD_NEWS, "command", new News());
    }

    @RequestMapping(value="/add-news", method=RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")News news, ModelMap model) {
        model.addAttribute("news", news);
        return ViewConstants.NEWS_VIEW;
    }

}
