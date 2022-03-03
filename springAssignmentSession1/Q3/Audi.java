package com.example.demo.spring;

import org.springframework.stereotype.Component;

public class Audi implements Automobile{

    @Override
    public void manufacturer() {
        System.out.println("Audi is getting manufactured.");
    }
}
