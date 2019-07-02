package com.sri.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.sri.spring.aop")
public class BeanConfig {
	
	@Bean
	public Student student ()
	{
		Student student =  new Student();
		student.setName("sri");
		student.setAge(25);
		return student;
	}
	

}
