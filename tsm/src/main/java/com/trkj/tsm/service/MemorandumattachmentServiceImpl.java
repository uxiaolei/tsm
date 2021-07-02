package com.trkj.tsm.service;

import com.trkj.tsm.dao.MemorandumattachmentDao;
import com.trkj.tsm.entity.Memorandumattachment;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.MemorandumattachmentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MemorandumattachmentServiceImpl implements MemorandumattachmentService {
    @Resource
    private MemorandumattachmentDao memorandumattachmentDao;

    @Override
    public List<MemorandumattachmentVo> seleAllmemorandumatt(String flag) {
        return memorandumattachmentDao.seleAllmemorandumatt(flag);
    }

    @Override
    public List<MemorandumattachmentVo> seleAllmemorandumatt1() {
        return memorandumattachmentDao.seleAllmemorandumatt1();
    }

    @Override
    public Memorandumattachment addmemorandumatt(Memorandumattachment memorandumattachment) {
        log.debug("新增学员交接学生");
        Memorandumattachment memoranduma=new Memorandumattachment();
        BeanCopyUtil.copyProperties(memorandumattachment,memoranduma);
        log.debug(memoranduma.toString());
        memorandumattachmentDao.insertSelective(memoranduma);
        return memoranduma;
    }

    @Override
    public int upzsisexamine(Memorandumattachment memorandumattachment) {
        log.debug("点击招生审核通过");
        return memorandumattachmentDao.upzsisexamine(memorandumattachment);
    }

    @Override
    public int upjwisexamine(Memorandumattachment memorandumattachment) {
        log.debug("点击教务审核通过");
        return memorandumattachmentDao.upjwisexamine(memorandumattachment);
    }

    @Override
    public List<Memorandumattachment> yshzsisexamine() {
        log.debug("招生已审核查询");
        return memorandumattachmentDao.yshzsisexamine();
    }

    @Override
    public List<Memorandumattachment> wshzsisexamine() {
        log.debug("招生未审核查询");
        return memorandumattachmentDao.wshzsisexamine();
    }

    @Override
    public List<Memorandumattachment> yshjwisexamine() {
        log.debug("教务已审核查询");
        return memorandumattachmentDao.yshjwisexamine();
    }

    @Override
    public List<Memorandumattachment> wshjwisexamine() {
        log.debug("教务未审核查询");
        return memorandumattachmentDao.wshjwisexamine();
    }

}
