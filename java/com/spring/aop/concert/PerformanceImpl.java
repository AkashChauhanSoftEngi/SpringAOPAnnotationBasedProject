package com.spring.aop.concert;

import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance{

	@Override
	public void perform() {
			System.out.println("Performance one started!");
	}

	@Override
	public int perform(int a) {
		System.out.println("Performance two started!");
		return a;
	}
}
