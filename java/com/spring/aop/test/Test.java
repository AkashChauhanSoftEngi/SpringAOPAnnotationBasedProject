package com.spring.aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.aop.concert.Performance;
import com.spring.aop.config.AppConfiguration;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Performance performance = (Performance)ctx.getBean(Performance.class);
		performance.perform();
		System.out.println();
		performance.perform(2);
		((AbstractApplicationContext) ctx).close();
	}
}
