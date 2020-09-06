package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// ClassPathXML yerine config dosyasi geldigi icin AnnotationConfig kullanilir.
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(IocConfig.class);
		ICustomerService customerService=context.getBean("service",ICustomerService.class);
		  
		//context.refresh();
		
		//CustomerManager manager1=new CustomerManager(context.getBean("database",ICustomerDal.class));
		customerService.add();
	
		

	}

}
