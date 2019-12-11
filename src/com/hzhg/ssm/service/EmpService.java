package com.hzhg.ssm.service;


import com.hzhg.ssm.pojo.Emp;

public interface EmpService {
    public Emp get(int uid);
    public void transform(int from_uid, int to_uid, double sal);
}
