package com.cspp.springpractice.util.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.cspp.springpractice.api.car.CarController.*(..))")
	public void logCarController(JoinPoint joinPoint) {
		LOGGER.info("*** " + joinPoint.getSignature().getName() + " has been called, with parameter:");
		Object[] objects = joinPoint.getArgs();
		Arrays.stream(objects).forEach(object -> LOGGER.info(object.toString()));
	}

}
