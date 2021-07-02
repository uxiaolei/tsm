package com.trkj.tsm.service;

import com.trkj.tsm.dao.SuspendDao;
import com.trkj.tsm.entity.Suspend;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.SuspendVo;
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
public class SuspendServiceImpl implements SuspendService {
    @Resource
    private SuspendDao suspendDao;
    @Override
    public List<SuspendVo> selectAllSuspend() {
        return suspendDao.selectAllSuspend();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "suspendVo",key = "#suspendVo.getSuspendId()")})
    public SuspendVo addSuspend(SuspendVo suspendVo) {
        Suspend suspend = new Suspend();
        BeanCopyUtil.copyProperties(suspendVo,suspend);
        suspend.setSuspendTime(new Date());
        suspend.setSuspendHandler("067");
        suspendDao.insertSelective(suspend);
        log.debug(suspend.toString()+"__________________________");
        return suspendVo;
    }

    @Override
    public SuspendVo updateSuspend(SuspendVo suspendVo) {
        Suspend suspend = new Suspend();
        BeanCopyUtil.copyProperties(suspendVo,suspend);
        suspend.setUpdatename("楼子知错就改");
        suspend.setUpdatetime(new Date());
        suspendDao.updateByPrimaryKeySelective(suspendVo);
        return suspendVo;
    }

    @Override
    public int updateSuspend_Approval1(Integer suspendId) {
        SuspendVo suspendVo = new SuspendVo();
        suspendVo.setSuspendApproval(1);
        suspendVo.setSuspendSapptime(new Date());
        suspendVo.setSuspendSappname("楼子");
        suspendVo.setSuspendId(suspendId);
        return suspendDao.updateByPrimaryKeySelective(suspendVo);
    }

    @Override
    public int deleteSuspend(Integer suspendId) {
        SuspendVo suspendVo = new SuspendVo();
        suspendVo.setTimeliness(1);
        suspendVo.setDeletename("黑手");
        suspendVo.setDeletetime(new Date());
        suspendVo.setSuspendId(suspendId);
        return suspendDao.updateByPrimaryKeySelective(suspendVo);
    }
}
