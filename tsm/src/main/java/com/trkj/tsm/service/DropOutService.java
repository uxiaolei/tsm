package com.trkj.tsm.service;

import com.trkj.tsm.vo.DropoutVo;
import net.sf.jsqlparser.statement.drop.Drop;

import java.util.List;

public interface DropOutService {
    List<DropoutVo> selectAllDrop();
    DropoutVo addDrop(DropoutVo dropoutVo);
    int updateDrop(DropoutVo dropoutVo);
    int updateDropisPay1(Integer dropId);
    int updateDropisPay2(Integer dropId);
    int updateDropJW_Approval1(Integer dropId);
    int updateDropJW_Approval0(Integer dropId);
    int deleteDrop(Integer dropId);
}
