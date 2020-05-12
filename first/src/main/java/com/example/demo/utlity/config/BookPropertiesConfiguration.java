package com.example.demo.utlity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("book")
public class BookPropertiesConfiguration {
	
	private String title;
	private String description;
	private String price;
	private String publish;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	@Override
	public String toString() {
		return "BookPropertiesConfiguration [title=" + title + ", description=" + description + ", price=" + price
				+ ", publish=" + publish + "]";
	}

}
