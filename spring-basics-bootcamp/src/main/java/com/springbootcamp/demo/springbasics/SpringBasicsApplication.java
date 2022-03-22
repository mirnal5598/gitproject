package com.springbootcamp.demo.springbasics;

import com.springbootcamp.demo.springbasics.component.ExpressTea;
import com.springbootcamp.demo.springbasics.component.Restaurant;
import com.springbootcamp.demo.springbasics.component.Tea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBasicsApplication.class, args);
		Restaurant restaurant = applicationContext.getBean(Restaurant.class);
		restaurant.getHotDrink().prepareHotDrink();
//        applicationContext.getBean(Tea.class).prepareHotDrink();
//        applicationContext.getBean(ExpressTea.class).prepareHotDrink();
    }

}
