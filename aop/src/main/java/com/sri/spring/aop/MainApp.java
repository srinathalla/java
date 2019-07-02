package com.sri.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
	      
	      Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();
	      
	      student.printThrowException();
	      
	      context.close();
	   }

}
