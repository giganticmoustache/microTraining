package com.accounting.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting.model.PaymentRequest;

@RestController
@RequestMapping("/accounting")
public class AccountingRest {
	
	@Value("${server.port}")
	private int port;

	public String pay(final PaymentRequest request) {
		System.out.println("Request: " + request.toString());
		return "OK" + this.port;
	}
}
