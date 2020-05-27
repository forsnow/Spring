package com.xuesong.factory;

/**
 * @description: 创建Bean对象的工厂（Bean在计算机用语中，有可重用组件的意思）
 * @author: Snow
 * @create: 2020-05-20 15:13
 **/
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建我们的service和dao对象的
 *
 * 1.我们需要一个配置文件来配置我们的service和dao
 *   配置文件可以选择xml也可以选择 properties
 *   配置的内容：唯一标志 = 全限定类名 (key=value)
 * 2.读取配置文件中的配置的内容，反射创建对象
 */
public class BeanFactory {
    private static Properties properties;

    //定义一个Map存放，用于存放我们创建的对象，称为Map
    private static Map<String,Object> beans;

    static {
        try {
            properties = new Properties();
            //获取properties文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(is);

            //实例化容器
            beans = new HashMap<>();

            //取出所有的keys
            Enumeration keys = properties.keys();
            //遍历所有的keys
            while (keys.hasMoreElements()){
                //得到key
                String key = keys.nextElement().toString();
                //根据key得到路径
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把遍历配置文件信息得到的key和value放入map容器beans中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化错误");
        }
    }

    /**
     * @Description: 根据Bean的名称获取Bean对象
     * @Param: [beanName]
     * @Return: java.lang.Object
     * @Author: Snow
     * @Date: 2020/5/20
     **/
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * @Description: 根据Bean的名称获取Bean对象
     * @Param: [beanName]
     * @Return: java.lang.Object
     * @Author: Snow
     * @Date: 2020/5/20
    **/
//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();//每次都会调用默认钩构造函数创建对象
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//
//    }



}
