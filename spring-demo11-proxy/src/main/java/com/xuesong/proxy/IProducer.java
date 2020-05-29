package com.xuesong.proxy;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-28 16:27
 **/
public interface IProducer {

    void sellProduction(float money);

    void afterSale(float money);
}
