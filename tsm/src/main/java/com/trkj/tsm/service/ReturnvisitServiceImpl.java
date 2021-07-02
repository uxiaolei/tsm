package com.trkj.tsm.service;

import com.trkj.tsm.dao.ReturnvisitDao;
import com.trkj.tsm.entity.Returnvisit;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.RegisterVo;
import com.trkj.tsm.vo.ReturnvisitVo;
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
public class ReturnvisitServiceImpl implements ReturnvisitService {
    @Resource
    private ReturnvisitDao returnvisitDao;

    @Override
    public List<ReturnvisitVo> selectAllvisit() {
        return returnvisitDao.selectAllvisit();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "returnvisit",key = "#returnvisitVo.getreturnvisitId()")})//获取表名，vo类的id
    public ReturnvisitVo addreturnvisit(ReturnvisitVo returnvisitVo) {
        log.debug("新增回访记录");
        Returnvisit returnvisit=new Returnvisit();
        BeanCopyUtil.copyProperties(returnvisitVo,returnvisit);
        returnvisitDao.insertSelective(returnvisitVo);
        return returnvisitVo;
    }

    @Override
    public List<ReturnvisitVo> selectByPrimaryKey(Integer registerId) {
        log.debug("点击回访查询咨询登记内容");
        return returnvisitDao.selectByPrimaryKey(registerId);
    }

    @Override
    public int dereturnvisit(Integer returnvisitId) {
        log.debug("进行回访记录删除");
        ReturnvisitVo returnvisitVo=new ReturnvisitVo();
        returnvisitVo.setReturnvisitId(returnvisitId);
        returnvisitVo.setDeletename("Admin");
        returnvisitVo.setDeletetime(new Date());
        returnvisitVo.setTimeliness(1);
        return returnvisitDao.updateByPrimaryKeySelective(returnvisitVo);
    }

    @Override
    public List<ReturnvisitVo> selregistertotal() {
        log.debug("回访次数查询");
        return returnvisitDao.selregistertotal();
    }

}
