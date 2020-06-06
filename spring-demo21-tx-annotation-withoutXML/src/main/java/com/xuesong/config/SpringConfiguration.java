package com.xuesong.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:Spring的配置类，相当于bean.xml
 * @author: Snow
 * @create: 2020-06-04 15:01
 **/
@Configuration
@ComponentScan("com.xuesong")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

}
