package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam(name = "login") String login,
                        @RequestParam(name = "password") String password, ModelMap model) {
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        return "login";
    }
}
