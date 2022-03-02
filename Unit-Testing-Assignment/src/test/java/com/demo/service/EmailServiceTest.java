package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

    @Mock
    Order order;
    @Mock
    EmailService emailServiceMock;

    @InjectMocks
    OrderService orderService;
    @InjectMocks
    EmailService emailService;

    @Test(expected = RuntimeException.class)
    public void sendEmail() {
        Order order = new Order(10, "Biscuits", 50.05);
        emailService.sendEmail(order);
        verify(emailService).sendEmail(order);
    }

    @Test
    public void testSendEmail() {
        Order order = new Order(10, "Biscuits", 50.05);
       boolean value = emailService.sendEmail(order, "Dummy");
        assertEquals(true, value);
    }
}
