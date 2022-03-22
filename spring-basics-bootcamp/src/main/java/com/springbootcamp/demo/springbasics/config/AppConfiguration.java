package com.springbootcamp.demo.springbasics.config;


import com.springbootcamp.demo.springbasics.component.ExpressTea;
import com.springbootcamp.demo.springbasics.component.HotDrink;
import com.springbootcamp.demo.springbasics.component.Restaurant;
import com.springbootcamp.demo.springbasics.component.Tea;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class AppConfiguration {


//    @Primary
//    @Bean
    ExpressTea expressTea() {
        return new ExpressTea();
    }

//    @Bean
    Tea tea() {
        return new Tea();
    }

//    @Bean
    Restaurant restaurant(HotDrink hotDrink) {
        Restaurant restaurant = new Restaurant();
        restaurant.setHotDrink(hotDrink);
        return restaurant;
    }

}
