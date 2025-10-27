package org.example.di_springtest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceCheck {

  @Around("execution(* org.example.di_springtest.service.PostService.*(..))")
  public Object performanceCheck(ProceedingJoinPoint pjp) throws Throwable {
    long start = System.currentTimeMillis();
    Object result = pjp.proceed();
    long end = System.currentTimeMillis();
    String methodName = pjp.getSignature().getName();
    log.info("<<<<<<< Aop - {} method's performance : {} ms", methodName, end - start);
    return result;
  }
}
