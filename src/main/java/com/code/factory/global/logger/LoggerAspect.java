package com.code.factory.global.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;


import org.slf4j.Logger;

@Component
@Aspect
public class LoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    // 메서드 실행 전
    @Before("execution(* com.code.factory..*Service.*(..))")
    public void logBefore() {
        logger.info("Method execution started");
    }

    // 메서드 실행 후
    @After("execution(* com.code.factory..*Service.*(..))")
    public void logAfter() {
        logger.info("Method execution finished");
    }

    // 메서드 결과 반환 후
    @AfterReturning(value = "execution(* com.code.factory..*Service.*(..))", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("Method executed successfully with result: " + result);
    }

    // 예외 발생 시
    @AfterThrowing(value = "execution(* com.code.factory..*Service.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        logger.error("Exception occurred: " + exception.getMessage());
    }

    // 메서드 실행 전후 (Around)
    @Around("execution(* com.code.factory..*Service.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before method: " + joinPoint.getSignature());
        Object result = joinPoint.proceed(); // 실제 메서드 실행
        logger.info("After method: " + joinPoint.getSignature());
        return result;
    }
}
