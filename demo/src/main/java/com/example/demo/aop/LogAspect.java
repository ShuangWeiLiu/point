package com.example.demo.aop;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect // 通过@Aspect 注解声明一个切面。
@Component // @Component让此切面成为Spring 容器管理的Beano
public class LogAspect {
    // 通过@PointCut 注解声明切点
    @Pointcut("@annotation(com.example.demo.aop.MyAction)")
    public void annotationPointcut() {
    }

    // 通过@After注解声明一个通过，并使用@PointCut定义的切点。
    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 通过反射可获得注解上的属性，然后做日志记录相关的操作，
        MyAction action = method.getAnnotation(MyAction.class);
        System.out.println("注解式拦截 " + action.name()); //5
    }

    // 通过@Before注解声明一个建言，此建言直接使用拦截规则作为参数。
    @Before("execution(* com.example.demo.web..*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截,"+method.getName());
    }
}
