package com.example.demo.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BMW implements Automobile{

    @Override
    public void manufacturer() {
        System.out.println("BMW is getting manufactured.");
    }
}
