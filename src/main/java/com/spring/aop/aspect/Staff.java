package com.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Staff {
	
	@Before("execution(public void com.spring.aop.concert.Performance.perform())")
	public void staffAskForHelp(){
		System.out.println("Staff Gonna come and ask for the help!");
	}
	
	@AfterReturning("execution(public void com.spring.aop.concert.Performance.perform())")
	public void staffWorkManagement(){
		System.out.println("Staff now open the curtains for the show!");
	}
}
