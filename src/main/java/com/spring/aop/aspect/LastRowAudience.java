package com.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class LastRowAudience {
	
	@Pointcut("execution(public void com.spring.aop.concert.Performance.perform(int))")
	public void performance(){}
	
	@Around("performance()")
	public void watchperformance(ProceedingJoinPoint jp){
		try {
			System.out.println("Number of Performances=" + Arrays.toString(jp.getArgs()));
			System.out.println("Signature: " + jp.getSignature());

			System.out.println("Silencing cell Phones");
			System.out.println("Taking Seats!");
			jp.proceed();
			System.out.println("Now, Clap Clap Clap");
		} catch (Throwable e) {
			System.out.println("Demanding Refund!");
		}
	}
	
	@Before("performance()")
	public void countNoOfPerformances(JoinPoint joinPoint){
		/*Using JointPoint, can access information related to the Method!*/
		System.out.println("Number of Performances=" + Arrays.toString(joinPoint.getArgs()));
		System.out.println("Signature: " + joinPoint.getSignature());
	}
	
	@Before("performance()&&args(a)")
	public void countNoOfPerformancesSecondWay(int a){
		/*One more way to get Arguments of the Method!*/
		System.out.println("Number of Performances=" + a);
	}
}
