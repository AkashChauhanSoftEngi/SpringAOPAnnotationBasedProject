package com.spring.aop.concert;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance{

	@Override
	public void perform() {
			System.out.println("Performance one started!");
	}

	@Override
	public void perform(int a) {
		System.out.println("Performance two started!");
		int p=0;
		int d=34/p;
		System.out.println(d);/*Divide by Zero exception will occur*/
	}
}
