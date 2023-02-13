package com.slokam.springbootHibernate.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspects {

	private final static Logger LOGGER = LoggerFactory.getLogger(loggingAspects.class);
	
	@Before("execution(* com.slokam.springbootHibernate.*.*.*(..) )")
	public void beforeMethod(JoinPoint jp)
	{
		String methodname= jp.getSignature().getName();
		String classname=jp.getTarget().getClass().toString();
		LOGGER.info("Entered into method "+ methodname +" of the " + classname);
	}
	@After("execution(* com.slokam.springbootHibernate.*.*.*(..) )")
	public void afterMethod(JoinPoint jp)
	{
		String methodname= jp.getSignature().getName();
		String classname=jp.getTarget().getClass().toString();
		LOGGER.info("exit from method "+ methodname +" of the " + classname);
	}
}
