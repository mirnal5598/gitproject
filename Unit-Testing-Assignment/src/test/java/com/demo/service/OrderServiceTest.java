package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyDouble;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    Order order;
    @Mock
    EmailService  emailServiceMock;

    @InjectMocks
    OrderService orderService;
    @InjectMocks
    EmailService emailService;

    @Test(expected = RuntimeException.class)
    public void testplaceOrder(){
        OrderService orderService =  new OrderService();
        Order orderItem = new Order(10, "Biscuits", 50.05);
            orderService.placeOrder(orderItem);
            verify(orderService).placeOrder(orderItem);

        }
    @Test
    public void testplaceOrder_bool(){
        Order order = new Order(10, "Biscuits", 50.05);
       boolean value = orderService.placeOrder(order, "Dummy");
       when(orderService.placeOrder(order, "Dummy")).thenReturn(true);
       assertEquals(true, orderService.placeOrder(order, "Dummy"));

    }
    }

