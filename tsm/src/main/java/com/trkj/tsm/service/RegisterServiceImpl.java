package com.trkj.tsm.service;

import com.trkj.tsm.dao.RegisterDao;
import com.trkj.tsm.entity.Register;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterDao registerDao;

    @Override
    public List<RegisterVo> selectregisterAlls() {
        return registerDao.selectregisterAlls();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "register",key = "#registerVo.getRegisterId()")})//获取表名，vo类的id
    public RegisterVo addRegister(RegisterVo registerVo) {
        log.debug("新增咨询登记");
        Register r=new Register();
        BeanCopyUtil.copyProperties(registerVo,r);
        registerDao.insertSelective(registerVo);
        return registerVo;
    }

    @Override
    public int updateRegister(RegisterVo registerVo) {
        RegisterVo register=new RegisterVo();
        BeanCopyUtil.copyProperties(registerVo,register);
        register.setLastupdatetime(new Date());
        return registerDao.updateByPrimaryKeySelective(register);
    }


    @Override
    public int deleteRegister(Integer registerId) {
        log.debug("删除咨询登记信息成功");
        RegisterVo re=new RegisterVo();
        re.setRegisterId(registerId);
        re.setDeletetime(new Date());
        re.setTimeliness(1);
        return registerDao.updateByPrimaryKeySelective(re);
    }

    @Override
    public List<RegisterVo> mhselectregister(String flag) {
        log.debug("模糊查询");
        return registerDao.mhselectregister(flag);
    }

    @Override
    public int upPayState(RegisterVo registerVo) {
        return registerDao.upPayState(registerVo);
    }

    /*通过咨询登记获取生源渠道的id*/
    @Override
    public RegisterVo selectByPrimaryKey(Integer registerId) {
        return registerDao.selectByPrimaryKey(registerId);
    }

    @Override
    public List<Register> ConsultationmodeStatistics() {
        return registerDao.ConsultationmodeStatistics();
    }

}
