package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Automobile automobile;


    public Car(Automobile automobile) {
        this.automobile = automobile;
    }

    public void startProcess(){
        System.out.println("Car process is starting.");
        automobile.manufacturer();
    }
}
