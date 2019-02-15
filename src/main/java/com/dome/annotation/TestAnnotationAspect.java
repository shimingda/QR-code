package com.dome.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Simon
 * @create 2019-02-15 14:22
 * @desc 切面
 **/
@Aspect
@Component
public class TestAnnotationAspect {

    @Pointcut("@annotation(TestAnnotation)")
    public void annotationPointcut(){

    }

    @Pointcut("execution(* com.dome..*.*(..))")
    public void save() {
    }
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        String value = annotation.value();
        System.out.println("准备"+value);
    }
    @Around("annotationPointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature =  (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        String value = annotation.value();
        System.out.println("正在执行"+value);
    }
    @After("save()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        String value = annotation.value();
        System.out.println("结束" + value);
    }

}
