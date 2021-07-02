package com.trkj.tsm.service;

import com.trkj.tsm.entity.Register;
import com.trkj.tsm.vo.RegisterVo;

import java.util.List;
import java.util.Map;

public interface RegisterService {
    List<RegisterVo> selectregisterAlls();
    RegisterVo addRegister(RegisterVo registerVo);
    int updateRegister(RegisterVo registerVo);
    int deleteRegister(Integer registerId);
    List<RegisterVo> mhselectregister(String flag);//模糊查询
    int upPayState (RegisterVo registerVo);//修改缴费状态
    RegisterVo selectByPrimaryKey(Integer registerId);//通过咨询登记的id查询生源渠道的id
    List<Register> ConsultationmodeStatistics();
}
