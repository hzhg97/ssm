package com.hzhg.ssm.web;


import com.hzhg.ssm.pojo.Emp;
import com.hzhg.ssm.service.EmpService;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class TestDemo {
    @Test
    public void test() {
        //1. 获取到一个上下问对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        EmpService empService = (EmpService) applicationContext.getBean("empService");
        empService.transform(1, 2, 1000);
    }

    @Test
    public void testJdbc() {
        //1. 创建c3p0的数据库连接池
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.6.135:3306/szbap_dm");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        //2. 创建了一个jdbc的模板对象：spring-jdbc.jar
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3. 查询所有的t_emp表中的数据
        String sql = "select * from t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                int uid = resultSet.getInt("uid");
                String uname = resultSet.getString("uname");
                double sal = resultSet.getDouble("sal");
                Emp user = new Emp();
                user.setUid(uid);
                user.setUname(uname);
                user.setSal(sal);
                return user;
            }
        });

        System.out.println(list);
    }
}
