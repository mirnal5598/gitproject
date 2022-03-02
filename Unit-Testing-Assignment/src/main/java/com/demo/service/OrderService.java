package com.demo.service;

import com.demo.data.api.TodoService;
import com.demo.domain.Order;
public class OrderService {

    private static OrderService instance;
    private EmailService emailService;
    private TodoService todoService;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public OrderService() {
        emailService = EmailService.getInstance();
        this.todoService = todoService;
    }

    void placeOrder(Order order) {
        double priceWithTax = order.getPrice() * 20 / 100;
        order.setPriceWithTax(priceWithTax);
        emailService.sendEmail(order);
        order.setCustomerNotified(true);
    }

    boolean placeOrder(Order order, String cc) {
        double priceWithTax = order.getPrice() * 20 / 100;
        order.setPriceWithTax(priceWithTax);
        boolean isNotified = emailService.sendEmail(order, cc);
//        System.out.println("Valuee: "+isNotified);
        order.setCustomerNotified(isNotified);
        return isNotified;
    }
}

