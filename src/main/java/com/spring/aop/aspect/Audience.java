package com.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Audience {
	
	@Before("execution(public void com.spring.aop.concert.Performance.perform())")
	public void silenceCellPhones(){
		System.out.println("Silencing cell Phones");
	}
	
	@Before("execution(public void com.spring.aop.concert.Performance.perform())")
	public void takingSeats(){
		System.out.println("Taking Seats!");
	}
	
	@AfterReturning("execution(public void com.spring.aop.concert.Performance.perform())")
	public void applause(){
		System.out.println("Now, Clap Clap Clap");
	}
	
	@AfterThrowing("execution(public void com.spring.aop.concert.Performance.perform())")
	public void demandRefund(){
		System.out.println("Demanding a return!");
	}

}
