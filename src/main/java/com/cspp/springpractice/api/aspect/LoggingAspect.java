package com.cspp.springpractice.api.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* com.cspp.springpractice.api.car.CarController.*(..))")
	public void logCarController(JoinPoint joinPoint) {
		System.out.println("*** " + joinPoint.getSignature().getName() + " has been called, with parameter:");
		Object[] objects = joinPoint.getArgs();
		Arrays.stream(objects).forEach(System.out::println);
	}

}
