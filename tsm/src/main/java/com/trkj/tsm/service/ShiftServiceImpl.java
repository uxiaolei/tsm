package com.trkj.tsm.service;

import com.trkj.tsm.dao.ClassesDao;
import com.trkj.tsm.dao.ShiftDao;
import com.trkj.tsm.entity.Shift;

import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.ShiftVo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ShiftServiceImpl implements ShiftService {
    @Resource
    private ShiftDao shiftDao;
    @Resource
    private ClassesDao classesDao;

    @Override
    public List<ShiftVo> selectAllShift() {

        return shiftDao.selectAllShift();
    }

    @Override
    public ShiftVo addShift(ShiftVo shiftVo) {
        Shift shift = new Shift();
        BeanCopyUtil.copyProperties(shiftVo, shift);
        shift.setShiftTime(new Date());
        shift.setNewclass(classesDao.selectByPrimaryKey(shiftVo.getClassesId()).getClassesName());
        shiftDao.insertSelective(shift);
        log.debug(shift.toString() + "__________________________");
        return shiftVo;
    }

    @Override
    public ShiftVo updateShift(ShiftVo shiftVo) {
        Shift shift = new Shift();
        BeanCopyUtil.copyProperties(shiftVo, shift);
        shiftDao.updateByPrimaryKeySelective(shiftVo);
        return shiftVo;
    }

    @Override
    public int appShift_Approval1(Integer shiftId) {
        ShiftVo shiftVo = new ShiftVo();
        shiftVo.setApproval(1);
        shiftVo.setJwApptime(new Date());
        shiftVo.setShiftId(shiftId);
        return shiftDao.updateByPrimaryKeySelective(shiftVo);
    }

    @Override
    public int deleteShift(Integer shiftId) {
        ShiftVo shiftVo = new ShiftVo();
        shiftVo.setDeletetime(new Date());
        shiftVo.setShiftId(shiftId);
        return shiftDao.updateByPrimaryKeySelective(shiftVo);
    }
}
