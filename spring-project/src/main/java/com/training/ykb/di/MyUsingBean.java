package com.training.ykb.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyUsingBean {

	@Autowired
	@Qualifier("ali")
	private MyFirstBean firstBean;
	
	private final MyFirstBean constructorInjectedFirstBean;
	
	private MyFirstBean methodInjectedFirstBean;
	
	@Autowired
	public MyUsingBean(@Qualifier("veli")final MyFirstBean constructorInjectedFirstBean) {
		System.out.println("constructor");
		this.constructorInjectedFirstBean = constructorInjectedFirstBean;
		constructorInjectedFirstBean.hello();
	}
	
	@Autowired
	public void methodInjection(@Qualifier("ali")final MyFirstBean methodInjectedFirstBean) {
		System.out.println("method injection");
		this.methodInjectedFirstBean = methodInjectedFirstBean;
	}
	
	@PostConstruct
	public void initBean() {
		System.out.print("post construct.");
	}
	
	@PreDestroy
	public void destroyBean() {
		System.out.println("destroy bean.");
	}
	
	public String exec() {
		return "Executed: " + firstBean.hello();
	}
}
