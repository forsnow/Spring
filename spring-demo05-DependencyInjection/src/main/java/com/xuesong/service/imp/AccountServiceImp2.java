package com.xuesong.service.imp;

import com.xuesong.service.AccountService;

import java.util.Date;

/**
 * 账户业务实现层
 * @author Snow
 * @date 2020/5/20-14:21
 */
public class AccountServiceImp2 implements AccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountService的方法执行了");
        System.out.println(name+" "+age+" "+birthday);
    }


}
