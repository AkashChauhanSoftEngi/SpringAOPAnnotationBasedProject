package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {
	
	@Pointcut("execution(public * com.spring.aop.concert.Performance.perform(..))")
	public void performance(){}
	
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
	
	@Around("performance()")
	public void watchperformance(ProceedingJoinPoint jp){
		try {
			System.out.println("Silencing cell Phones");
			System.out.println("Taking Seats!");
			jp.proceed();
			System.out.println("Now, Clap Clap Clap");
		} catch (Throwable e) {
			System.out.println("Demanding a return!");
		}
	}
}
