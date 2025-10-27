package org.example.di_springtest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class Logging {

  @Before("execution(* org.example.di_springtest.controller.PostController.*(..))")
  public void makeLog(JoinPoint jp){
    String methodName = jp.getSignature().getName();
    String className = jp.getTarget().getClass().getSimpleName();
    log.info("<<<<<< AOP {} : {} 가 실행되기 전 ", className, methodName);
  }
}
