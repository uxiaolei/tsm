package com.trkj.tsm.service;

import com.trkj.tsm.dao.SourceDao;
import com.trkj.tsm.entity.Source;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.SourceVo;
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
public class SourceServiceImpl implements SourceService {
    @Resource
    private SourceDao sourceDao;

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "source",key = "#sourceVo.getSourceId()")})//获取表名，vo类的id
    public SourceVo addSource(SourceVo sourceVo) {
        log.debug("新增渠道信息");
        Source s=new Source();//调用实体类
        BeanCopyUtil.copyProperties(sourceVo,s);
        sourceDao.insertSelective(sourceVo);
        return sourceVo;
    }

    @Override
    public int deleteSource(Integer sourceId) {//sourceId 从前端传过来的id
        log.debug("删除渠道信息成功");
        SourceVo sourceVo=new SourceVo();
        sourceVo.setSourceId(sourceId);
        sourceVo.setDelchannelname("Admin");
        sourceVo.setDelchanneltime(new Date());
        sourceVo.setTimeliness(1);
        return sourceDao.updateByPrimaryKeySelective(sourceVo);
    }

    @Override
    public SourceVo updateSource(SourceVo sourceVo) {
        log.debug("修改渠道维护信息成功");
        SourceVo so=new SourceVo();
        sourceVo.setLastupdatetime(new Date());
        BeanCopyUtil.copyProperties(sourceVo,so);
        sourceDao.updateByPrimaryKeySelective(sourceVo);
        return sourceVo;
    }


    @Override
    public List<SourceVo> conditionselect(String flag) {
        log.debug("模糊查询成功");
        return sourceDao.conditionselect(flag);
    }


}
