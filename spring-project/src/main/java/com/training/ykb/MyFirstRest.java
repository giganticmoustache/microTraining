package com.training.ykb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@controller mvcdeki web controller
//@repository db erişimi
//@service business logicler için
//@configuration spring configuration için

@RestController
@RequestMapping("/test")
public class MyFirstRest {

	@GetMapping
	public String hello() {
		return "Hello world!";
	}
}
