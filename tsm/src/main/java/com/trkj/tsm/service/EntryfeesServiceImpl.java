package com.trkj.tsm.service;

import com.trkj.tsm.dao.EntryfeesDao;
import com.trkj.tsm.entity.Entryfees;
import com.trkj.tsm.util.BeanCopyUtil;
import com.trkj.tsm.vo.EntryfeesVo;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class EntryfeesServiceImpl implements EntryfeesService {
    @Resource
    private EntryfeesDao entryfeesDao;
    //查询显示所有
    @Override
    public List<EntryfeesVo> selectAllentryfees() {
        return entryfeesDao.selectAllentryfees();
    }

    @Override
    public int deleteEntryfees(Integer feesId) {
        log.debug("删除报班缴费信息");
        Entryfees entryfees=new Entryfees();
        entryfees.setFeesId(feesId);
        entryfees.setTimeliness(1);
        return entryfeesDao.updateByPrimaryKeySelective(entryfees);
    }

    @Override
    public List<Entryfees> selefeesType() {
       List<Entryfees> Entryfeesaa= entryfeesDao.selefeesType();
/*       for (Entryfees e:Entryfeesaa){
           //剩余学费=应收金额-实收金额
           e.setAccumulated(e.getCourse().getCourseMoney().subtract(e.getReceipts()));
        }*/
        log.debug(Entryfeesaa.toString());
        return Entryfeesaa;//查询缴费状态
    }

    @Override
    public Entryfees addentryfees(Entryfees entryfees) {
        Entryfees en=new Entryfees();
        BeanCopyUtil.copyProperties(entryfees,en);
        String num="XS";//定义一个固定值
        DateFormat dateFormat=new SimpleDateFormat("ddhhmmss");//时间的精确值
        String feesname=num+dateFormat.format(new Date())+en.toString().length();
        en.setFeesName(feesname);
        log.debug(en.toString());
        entryfeesDao.insertSelective(en);
        log.debug("新增报班缴费");
        return en;
    }

    @Override
    public int upentryfees(Entryfees entryfees) {
        Entryfees en=new Entryfees();
        BeanCopyUtil.copyProperties(entryfees,en);
        en.setUpdatename("admin");
        en.setUpdatetime(new Date());
        log.debug(entryfees.toString());
        //*课程钱=实收金额*//*en.getReceipts()
       /* if (en.getCourse().getCourseMoney().compareTo(en.getReceipts())==0||en.getAccumulated().equals(0)){
            en.setFeesType(0);
        }else{
            en.setFeesType(1);
        }*/
        if (en.getCourse().getCourseMoney().compareTo(en.getReceipts())==0){
            en.setFeesType(0);
        }else if (en.getAccumulated().equals(0.000)){
            en.setFeesType(0);
        }else{
            en.setFeesType(1);
        }

        return entryfeesDao.updateByPrimaryKeySelective(en);
    }

    @Override
    public int upfeesState(Entryfees entryfees) {
        return entryfeesDao.upfeesState(entryfees);
    }

    @Override
    public int upaccumulated(Entryfees entryfees) {
        log.debug("修改剩余待缴金额");
        log.debug(entryfees.toString());
        Entryfees en=new Entryfees();
        return entryfeesDao.upaccumulated(entryfees);
    }
}
