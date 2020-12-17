package com.training.ykb.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//@Profile("dev")//ortama gore farklı ayarlar yapmak icin
//@Import(BeanConfig.class)
public class MyConfig {
	
	@Autowired
	private Environment env;
	
	@Value("${my.conf.abc}")
	private int port;
	
	@Value("#{myFirstBean.hello()}")
	private String hello;

	// spring beani kendi olusturmaz, buradan bakar, olusturmasi daha hizlidir. spring reflection kullandigindan burasi daha hizlidir.
	@Bean
	//@Primary
	@Qualifier("ali")
	public MyFirstBean createMyFirst() {
		String propertyLoc = this.env.getProperty("my.conf.abc");
		int parseIntLoc = Integer.parseInt(propertyLoc);
		System.out.println("from env : " + parseIntLoc);
		System.out.println("from value : " + this.port);
		System.out.println("from bean : " + this.hello);
		return new MyFirstBean();
	}
}
