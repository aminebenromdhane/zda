package com.orion.zd.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class ProfilingAspect {
   
	@Aspect
	public class BusinessProfiler {

	        @Pointcut("execution(* com.orion.zd.estimator.*(..))")
	        public void businessMethods() {
	        	System.out.println("Going to call the method.");
	        }

	        @Around("businessMethods()")
	        public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	                long start = System.currentTimeMillis();
	                System.out.println("Going to call the method.");
	                Object output = pjp.proceed();
	                System.out.println("Method execution completed.");
	                long elapsedTime = System.currentTimeMillis() - start;
	                System.out.println("Method execution time: " + elapsedTime + " milliseconds.");
	                return output;
	        }

	}
   
}
