package com.xuesong.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description:用于记录日志的工具类，它里面提供了公共的代码
 * @author: Snow
 * @create: 2020-05-29 15:19
 **/
@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution(* com.xuesong.service.imp.*.*(..))")
    private void pt1(){

    }
    /*前置通知*/
    @Before("pt1()")
    public void BeforePrintLog(){
        System.out.println("前置通知：Logger类中的BeforePrintLog方法开始记录日志了");
    }

    /*返回通知*/
    @AfterReturning("pt1()")
    public void AfterReturningPrintLog(){
        System.out.println("返回通知：Logger类中的AfterReturningPrintLog方法开始记录日志了");
    }

    /*异常通知*/
    @AfterThrowing("pt1()")
    public void AfterThrowingPrintLog(){
        System.out.println("异常通知：Logger类中的AfterThrowingPrintLog方法开始记录日志了");
    }

    /*后置通知*/
    @After("pt1()")
    public void AfterPrintLog(){
        System.out.println("后置通知：Logger类中的AfterPrintLog方法开始记录日志了");
    }


    /*环绕通知
    * 问题：
    * 当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
    *
    * 通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
    * 解决：
    *     Spring的框架为我们提供了一个接口，ProceedingJoinPoint ,该接口有一个方法proceed() 此方法就相当于明确调用切入点方法。
    *     该接口可以最为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
    *
    * Spring中的环绕通知：
    *   它是spring框架中为我们提供的一种可以在代码中手动控制增强方法何时执行的方式
    * */
    //@Around("pt1()")
    public Object AroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object retrunValue = null;
        try {
            Object[] args = proceedingJoinPoint.getArgs();//得到方法执行所需的参数
            System.out.println("前置通知：Logger类中的AroundPrintLog方法开始记录日志了");
            retrunValue = proceedingJoinPoint.proceed();//明确调用业务层方法（切入点方法）
            System.out.println("后置通知：Logger类中的AroundPrintLog方法开始记录日志了");
            return retrunValue;
        } catch (Throwable throwable) {
            System.out.println("异常通知：Logger类中的AroundPrintLog方法开始记录日志了");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("最终通知：Logger类中的AroundPrintLog方法开始记录日志了");
        }

    }

}
