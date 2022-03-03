package com.example.demo.spring;

public class Car {
    private Automobile automobile;

    public void set(Automobile automobile){
        this.automobile = automobile;
    }
    public void startProcess(){
        System.out.println("Car process is starting.");
    automobile.manufacturer();
    }
}
