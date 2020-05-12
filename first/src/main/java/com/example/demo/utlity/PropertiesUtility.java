package com.example.demo.utlity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utlity.config.BookPropertiesConfiguration;

@RestController
public class PropertiesUtility {

	@Autowired
	private Environment environment;

	@Autowired
	private BookPropertiesConfiguration bookProperties;

	@Value("${my.info:My Name is Spring Boot}")
	private String info;

	// http://localhost:9000/getPortDetails
	@GetMapping("/getPortDetails")
	public String portDetails() {
		String property = environment.getProperty("server.port");
		return property;
	}

	// http://localhost:9000/info
	@GetMapping("/info")
	public String getInfo() {
		return info;
	}

	// http://localhost:9000/book/info
	@GetMapping("/book/info")
	public String getBookInfo() {

		return bookProperties.getTitle() + " " + bookProperties.getDescription() + " " + bookProperties.getPrice() + " "
				+ bookProperties.getPublish();

	}

}
