package com.xuesong.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @description:配置类，作用和bean.xml的作用一样
 * @author: Snow
 * @create: 2020-05-26 16:16
 **/

/*
*  @Configuration
* 用于指定当前类是一个 spring 配置类， 当创建容器时会从该类上加载注解。 获取容器时需要使用
*
* AnnotationApplicationContext(有@Configuration 注解的类.class)。
* 当配置类作为AnnotationApplicationContext的对象的参数时，改注解可以不写
*
*
* @ComponentScan
* 作用：用于指定 spring 在初始化容器时要扫描的包。
* 属性：value 和 basePackages 作用一样
*
* @Bean
* 作用：
* 该注解只能写在方法上，表明使用此方法创建一个对象，并且放入 spring 容器。
* 属性：name：给当前@Bean 注解方法创建的对象指定一个名称(即 bean 的 id）。
* 如果没有指定的bean的id，默认是方法的名称
*
* @PropertySource
* 指定文件的名称和文件的路径
*
* Tips:
* 当我们用注解配置方法时，如果方法有参数，Sping会去容器中查找有没有可用的bean对象
* 查找的方式和AutoWired注解一样
*
* */
@Configuration
@ComponentScan("com.xuesong")
@PropertySource("classpath:db.properties")
public class SpringConfiguration {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    /**
     * @Description: 用于创建一个QueryRunner
     * @Param: [dataSource]
     * @Return: org.apache.commons.dbutils.QueryRunner
     * @Author: Snow
    **/
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * @Description: 创建数据源对象
     * @Param: []
     * @Return: javax.sql.DataSource
     * @Author: Snow
    **/
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
}
