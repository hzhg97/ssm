package com.hzhg.ssm.service;

import com.hzhg.ssm.dao.EmpDao;
import com.hzhg.ssm.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    private EmpDao empDao;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public Emp get(int uid) {
        return empDao.get(uid);
    }


    public List<Emp> findEmpList() {
        return empDao.findEmpList();
    }

    @Override
    public void transform(int from_uid, int to_uid, double sal) {
        //1. 设置通过uid查询对象，并将转账之后的余额计算
        Emp emp1 = empDao.get(from_uid);
        emp1.setSal(emp1.getSal() - sal);

        Emp emp2 = empDao.get(to_uid);
        emp2.setSal(emp2.getSal() + sal);

        //2. 转账
        empDao.update(emp1);

        empDao.update(emp2);
    }
}