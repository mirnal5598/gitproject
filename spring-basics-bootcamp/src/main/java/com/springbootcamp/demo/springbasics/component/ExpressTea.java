package com.springbootcamp.demo.springbasics.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("expressTea")
public class ExpressTea implements HotDrink{

    public void prepareHotDrink() {
        System.out.println("Preparing Express Tea");
    }
}
