package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		
		
//		ApplicationContext springContainer =
//				SpringApplication.run(ProductappApplication.class, args);
//		
		ProductConsoleUI ui = new ProductConsoleUI();
		ui.createProductWithUI();
		
//		ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
//		ui.createProductWithUI();
		
	}
}
