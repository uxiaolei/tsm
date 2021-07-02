package com.trkj.tsm.service;

import com.trkj.tsm.entity.Refund;
import com.trkj.tsm.vo.BackVo;

import java.util.List;

public interface RefundService {
    List<Refund> seleAllRefund(String classesName);//查询所有
    int addRefund1(BackVo backVo);//新增退费信息
    int delRefund(Integer refundId);//删除
    int upcwApproval(Refund refund);//修改审批
}
