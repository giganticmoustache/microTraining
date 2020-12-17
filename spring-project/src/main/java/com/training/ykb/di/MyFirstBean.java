package com.training.ykb.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Scope("prototype")//singleton olmaktan çıkarır objeyi
@Qualifier("veli")
@Component
public class MyFirstBean {

	public String hello() {
		return "Hello from MyFirstBean.";
	}
}
