package com.trkj.tsm.service;

import com.trkj.tsm.dao.SemesterDao;
import com.trkj.tsm.vo.SemesterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class SemServiceImpl implements SemService {
    @Resource
    private SemesterDao semesterDao;

    @Override
    public List<SemesterVo>selectByPrimaryKey(){
        return semesterDao.selectByPrimaryKey();
    }

    @Override
    public SemesterVo insert(SemesterVo semestervo){

         semesterDao.insert(semestervo);
         return semestervo;
    }
    @Override
    public SemesterVo updatesem(SemesterVo semestervo){

        semesterDao.updateByPrimaryKeySelective(semestervo);
        return semestervo;
    }
    @Override
    public SemesterVo deletesem(SemesterVo semestervo){
        log.debug(semestervo.toString());
        semestervo.setTimeliness(1);
        semestervo.setDeletetime(new Date());
        semesterDao.updateByPrimaryKeySelective(semestervo);
        return semestervo;
    }
}
