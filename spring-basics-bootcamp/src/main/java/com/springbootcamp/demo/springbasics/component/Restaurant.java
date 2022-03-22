package com.springbootcamp.demo.springbasics.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class Restaurant {


    @Autowired
    @Qualifier("expressTea")
    HotDrink hotDrink;

    @PostConstruct
    void init() {
        System.out.println("Your bean is ready....");
    }


    public HotDrink getHotDrink() {
        return hotDrink;
    }

    public void setHotDrink(HotDrink hotDrink) {
        this.hotDrink = hotDrink;
    }
}
