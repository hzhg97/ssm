package com.hzhg.ssm.dao;


import com.hzhg.ssm.pojo.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class EmpDaoImpl implements EmpDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Emp get(int uid) {
        String sql = "select * from t_emp where uid = " + uid;
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
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<Emp> findEmpList() {
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
        return list;
    }

    @Override
    public void update(Emp emp) {
        String sql = "update t_emp set sal = "+ emp.getSal() + "where uid = " + emp.getUid();
        jdbcTemplate.update(sql);
    }
}
