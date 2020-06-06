package com.xuesong.service;

import org.springframework.stereotype.Service;

/**
 * @description:账户业务层接口
 * @author: Snow
 * @create: 2020-05-29 15:05
 **/

public interface AccountService {
    /*模拟保存操作  无参无返回值*/
    void saveAccount();

    /*模拟更新操作 有参无返回值*/
    void updateAccount(int i);

    /*模拟删除操作 无参有返回值*/
    int deleteAccount();
}
