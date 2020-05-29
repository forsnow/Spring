package com.xuesong.utils;

/**
 * @description:用于记录日志的工具类，它里面提供了公共的代码
 * @author: Snow
 * @create: 2020-05-29 15:19
 **/
public class Logger {
    /*前置通知*/
    public void BeforePrintLog(){
        System.out.println("Logger类中的BeforePrintLog方法开始记录日志了");
    }

    /*后置通知*/
    public void AfterPrintLog(){
        System.out.println("Logger类中的AfterPrintLog方法开始记录日志了");
    }

    /*返回通知*/
    public void AfterReturningPrintLog(){
        System.out.println("Logger类中的AfterReturningPrintLog方法开始记录日志了");
    }

    /*异常通知*/
    public void AfterThrowingPrintLog(){
        System.out.println("Logger类中的AfterThrowingPrintLog方法开始记录日志了");
    }

    /*环绕通知*/
    public void AroundPrintLog(){
        System.out.println("Logger类中的AroundPrintLog方法开始记录日志了");
    }

}
