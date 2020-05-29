package com.xuesong.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:模拟一个消费者
 * @author: Snow
 * @create: 2020-05-28 16:29
 **/
public class Client_cglib {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        Producer producerEnhancer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {

            /**
             * @Description: 执行代理对象的任何方法都会经过这个方法
             * @Param: [o, method, objects, methodProxy]
             * @Return: java.lang.Object
             * @Author: Snow
            **/
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                //1.获取方法执行的参数
                Float money = (Float) objects[0];
                //2.判断当前方法是不是销售
                if (method.getName().equals("sellProduction")){
                    returnValue = method.invoke(producer,money*0.8f);
                }

                return returnValue;
            }
        });

        producerEnhancer.sellProduction(10000);



    }
}
