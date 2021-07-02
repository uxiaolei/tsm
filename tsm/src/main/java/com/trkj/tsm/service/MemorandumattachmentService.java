package com.trkj.tsm.service;

import com.trkj.tsm.entity.Memorandumattachment;
import com.trkj.tsm.vo.MemorandumattachmentVo;

import java.util.List;

public interface MemorandumattachmentService {
    List<MemorandumattachmentVo> seleAllmemorandumatt(String flag);//查询显示
    List<MemorandumattachmentVo> seleAllmemorandumatt1();//招生审核为1的查询显示
    Memorandumattachment addmemorandumatt(Memorandumattachment memorandumattachment);//新增学员交接学生
    int upzsisexamine(Memorandumattachment memorandumattachment);//招生审核
    int upjwisexamine(Memorandumattachment memorandumattachment);//教务审核
    List<Memorandumattachment> yshzsisexamine();//招生已审核显示
    List<Memorandumattachment> wshzsisexamine();//招生未审核显示
    List<Memorandumattachment> yshjwisexamine();//教务已审核显示
    List<Memorandumattachment> wshjwisexamine();//教务未审核显示

}
