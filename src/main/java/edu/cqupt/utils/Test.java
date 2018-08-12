package edu.cqupt.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by aa on 2017/7/15.
 */
public class Test {
    public static void main(String[] args) {
        //依靠测试用的mybatis.xml配置文件手动创建获取SqlSessionFactory
        //********************************************************
        InputStream inputStream = Test.class.getClassLoader().
                getResourceAsStream("mybatis/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("输出factory:"+factory);
        //*******************************************************

        //测试
        //UserMapper mapper = factory.openSession().getMapper(UserMapper.class);
        //User user = mapper.selelctByName("张三");
        //System.out.println(user);


    }
}
