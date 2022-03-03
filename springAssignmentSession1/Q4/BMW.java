package com.example.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class BMW implements Automobile{

    @Override
    public void manufacturer() {
        System.out.println("BMW is getting manufactured.");
    }
}
