package com.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.aop.aspect.bean.TechnicalStaff;
import com.spring.aop.concert.Performance;
import com.spring.aop.config.AppConfiguration;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Performance performance = (Performance)ctx.getBean(Performance.class);
		
		/*To add new method using Spring AOP, Mainly it is used in Testing!*/
	    ((TechnicalStaff) performance).doTesting();
		
		performance.perform();
		System.out.println();
		performance.perform(2);
		
	    ((AbstractApplicationContext) ctx).close();
	}
}
