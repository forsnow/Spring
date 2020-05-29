package com.xuesong.cglib;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-28 15:57
 **/
public class Producer {
    /*销售*/
    public void sellProduction(float money){
        System.out.println("销售产品+获得钱"+money);
    }

    /*售后*/
    public void afterSale(float money){
        System.out.println("售后服务"+money);
    }
}
