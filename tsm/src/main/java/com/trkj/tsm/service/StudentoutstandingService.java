package com.trkj.tsm.service;

import com.trkj.tsm.entity.Studentoutstanding;

import java.util.List;

public interface StudentoutstandingService {
    List<Studentoutstanding> seleAllstudentout();//显示所有
    Studentoutstanding addStudentoutstanding(Studentoutstanding studentoutstanding);//新增
    int approvaltype(Studentoutstanding studentoutstanding);//修改审核状态
    List<Studentoutstanding> seleWapprovaltype();//查询为审核
    List<Studentoutstanding> seleYapprovaltype();//查询已审核
}
