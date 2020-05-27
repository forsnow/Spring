package com.xuesong.test;

import com.xuesong.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:测试queryRunner是否单例
 * @author: Snow
 * @create: 2020-05-27 13:57
 **/
public class queryRunnerTest {

    @Test
    public void Test(){
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取QueryRunner对象
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner1 == runner2);
        //结果是true

    }

}
