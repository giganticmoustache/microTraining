package com.training.ykb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.ykb.di.MyUsingBean;

//@SpringBootApplication(scanBasePackages = {"com.training.ykb"})//taranacak paketleri belirtmek için, config içinde yapılınca ihtiyac kalmadi.
@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class, args);
		
		MyUsingBean beanLoc = context.getBean(MyUsingBean.class);
		System.out.println(beanLoc.exec());
	}

}
