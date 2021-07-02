package com.trkj.tsm.service;


import com.trkj.tsm.vo.RegisterVo;
import com.trkj.tsm.vo.ReturnvisitVo;

import java.util.List;

public interface ReturnvisitService {
    List<ReturnvisitVo> selectAllvisit();//显示
    ReturnvisitVo addreturnvisit(ReturnvisitVo returnvisitVo);//新增
    List<ReturnvisitVo> selectByPrimaryKey(Integer registerId);//点击回访查询咨询登记
    int dereturnvisit(Integer returnvisitId);//删除
  //  List<ReturnvisitVo> selectByRegisterId(Integer rid);

    List<ReturnvisitVo> selregistertotal();//回访次数

}
