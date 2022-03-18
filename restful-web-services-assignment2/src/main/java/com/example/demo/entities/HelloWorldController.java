package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


    //Internationalization

    @GetMapping(path="/internationalised")
    public String internationalised(){
        return messageSource.getMessage("inter.message",null , LocaleContextHolder.getLocale());
    }

    @GetMapping("/hello-user")//type ?username=mirnal after getmapping url
    public String helloUser( @RequestParam String username) {
        return messageSource.getMessage("inter.message", null, LocaleContextHolder.getLocale())+" "+username;
    }

}
