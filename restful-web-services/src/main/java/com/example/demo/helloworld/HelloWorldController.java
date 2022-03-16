package com.example.demo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

//    @RequestMapping(method= RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World!!!, %s", name));
    }
//    @GetMapping(path="/hello-world-internationalised")
//    public String helloWorldInternationalised(
//            @RequestHeader(name="Accept-Language", required = false) Locale locale){
//        return messageSource.getMessage("good.morning.message",null , locale);
//    }

    //Another way to perform above operation and change SessionLocalResolver in main
    //to AcceptHeaderLocaleResolver
    @GetMapping(path="/hello-world-internationalised")
    public String helloWorldInternationalised(){
        return messageSource.getMessage("good.morning.message",null , LocaleContextHolder.getLocale());
    }
}