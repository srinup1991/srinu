package com.slokam.springbootHibernate.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@NoArgsConstructor
@Slf4j
public class performethodTimeAspect {
private long startTime;
private final static Logger LOGGER = LoggerFactory.getLogger(performethodTimeAspect.class);
	
/*
 * @Before("execution(* com.slokam.springbootHibernate.*.*.*(..) )") public void
 * beforeMethod() { startTime= System.currentTimeMillis();
 * 
 * 
 * }
 * 
 * @After("execution(* com.slokam.springbootHibernate.*.*.*(..) )") public void
 * afterMethod() { long endTime = System.currentTimeMillis(); long time=
 * endTime- startTime;
 * 
 * LOGGER.info("time taken for the execution of method is----> "+ time); }
 */


@Around("execution(* com.slokam.springbootHibernate.*.*.*(..) )")
public Object AroundMethod(ProceedingJoinPoint pjp)
{
	String methodname= pjp.getSignature().getName();
	String classname=pjp.getTarget().getClass().toString();
	long startTime = System.currentTimeMillis();
	Object obj = null;
	 
	try {
		obj = pjp.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long endTime = System.currentTimeMillis(); 
	long time= endTime- startTime;
	LOGGER.info("time taken for the execution of method for "+methodname +" of the "+ classname +" is "+time);
	return obj;
}
}