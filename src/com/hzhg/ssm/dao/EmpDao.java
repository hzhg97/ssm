package com.hzhg.ssm.dao;


import com.hzhg.ssm.pojo.Emp;

import java.util.List;

public interface EmpDao {
    public Emp get(int uid);

    public List<Emp> findEmpList();

    void update(Emp emp);
}
