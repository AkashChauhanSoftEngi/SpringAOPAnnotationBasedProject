package com.spring.aop.aspect.bean;

import org.springframework.stereotype.Component;

@Component
public class TechnicalStaffImpl implements TechnicalStaff {

	@Override
	public void doTesting() {
		System.out.println("Before performance started, Technical staff must perform testing!");
	}

}
