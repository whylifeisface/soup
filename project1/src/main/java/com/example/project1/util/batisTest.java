package com.example.project1.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class batisTest {
    private static SqlSessionFactory factory=null;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("TypeMapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getsession(){
        SqlSession session = null;
        if (factory!=null){
            session = factory.openSession();//true自动提交事务
        }
        return session;
    }
}
