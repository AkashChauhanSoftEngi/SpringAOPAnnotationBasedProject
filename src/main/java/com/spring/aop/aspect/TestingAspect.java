package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.spring.aop.aspect.bean.TechnicalStaff;
import com.spring.aop.aspect.bean.TechnicalStaffImpl;

@Aspect
@Component
public class TestingAspect {
	
	@DeclareParents(value="com.spring.aop.concert.Performance+" , defaultImpl=TechnicalStaffImpl.class)
	public static TechnicalStaff technicalStaff;
	
}
