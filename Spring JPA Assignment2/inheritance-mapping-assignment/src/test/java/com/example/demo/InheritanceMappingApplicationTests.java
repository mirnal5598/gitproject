package com.example.demo;

import com.example.demo.entities.Check;
import com.example.demo.entities.Creditcard;
import com.example.demo.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritanceMappingApplicationTests {

	@Autowired
	PaymentRepository repository;
	@Test
	public void createPayment() {
		Creditcard cc = new Creditcard();
		cc.setId(121);
		cc.setAmount(1000);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	}

	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(131);
		ch.setAmount(1000);
		ch.setChecknumber("1234567890");
		repository.save(ch);
	}
}
