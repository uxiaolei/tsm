package com.trkj.tsm.service;


import com.trkj.tsm.entity.Entryfees;
import com.trkj.tsm.vo.EntryfeesVo;

import java.util.List;

public interface EntryfeesService {
    List<EntryfeesVo> selectAllentryfees();//显示
    int deleteEntryfees(Integer feesId);//修改时效性
    List<Entryfees> selefeesType();//查询缴费状态
    Entryfees addentryfees(Entryfees entryfees);//新增缴费
    int upentryfees(Entryfees entryfees);//upPayState
    int upfeesState(Entryfees entryfees);//点击审核通过修改缴费状态
    int upaccumulated(Entryfees entryfees);//新增学员欠费补缴的同时修改剩余待缴金额

}
