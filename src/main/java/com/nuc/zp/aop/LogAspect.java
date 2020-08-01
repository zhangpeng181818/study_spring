package com.nuc.zp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut(value = "execution(* com.nuc.zp.aop.User.add(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before ......");
    }

    @After("execution(* com.nuc.zp.aop.User.add(..))")
    public void after(){
        System.out.println("after ......");
    }

    @AfterThrowing("execution(* com.nuc.zp.aop.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing ......");
    }

    @AfterReturning("execution(* com.nuc.zp.aop.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning ......");
    }

    @Around("execution(* com.nuc.zp.aop.User.add(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around之前 ......");

        Object proceed = joinPoint.proceed();
        System.out.println("around之后 ......");
    }
}
