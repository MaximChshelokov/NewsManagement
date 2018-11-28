package com.epam.controller;

import com.epam.util.ReadableResourceBundleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Properties;

@RestController
@RequestMapping("/messages")
public class I18nController {

    private ReadableResourceBundleMessageSource messageBundle;

    @GetMapping
    public ResponseEntity<Properties> getMessageBundleProperties(
        @RequestParam("lang")
            String lang) {
        return new ResponseEntity<>(messageBundle.getAllProperties(new Locale(lang)), HttpStatus.OK);
    }

    @Autowired
    public void setMessageBundle(ReadableResourceBundleMessageSource messageBundle) {
        this.messageBundle = messageBundle;
    }
}
