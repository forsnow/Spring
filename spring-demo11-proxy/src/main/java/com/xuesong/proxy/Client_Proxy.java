package com.xuesong.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:模拟一个消费者
 * @author: Snow
 * @create: 2020-05-28 16:29
 **/
public class Client_Proxy {
    public static void main(String[] args) {
        final Producer producerImp = new Producer();
        //producerImp.sellProduction(10000);

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producerImp.getClass().getClassLoader(),
                producerImp.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     * @Description: 执行被代理对象的任何接口方法都会经过该方法
                     * @Param: [proxy, method, args]
                     * proxy：代理对象的引用
                     * method：当前执行的方法
                     * args：当前执行方法所需的参数
                     *
                     * @Return: java.lang.Object
                     * return：和被代理对象有相同的返回值
                     *
                     * @Author: Snow
                    **/

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        //1.获取方法执行的参数
                        Float money = (Float) args[0];
                        //2.判断当前方法是不是销售
                        if (method.getName().equals("sellProduction")){
                            returnValue = method.invoke(producerImp,money*0.8f);
                        }

                        return returnValue;


                        //匿名内部类访问外部成员变量时，外部成员要求是最终的

                    }
                });

        proxyProducer.sellProduction(1000);
    }
}
