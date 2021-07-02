package com.trkj.tsm.service;

import com.trkj.tsm.dao.OpjournalDao;
import com.trkj.tsm.vo.OpjournalVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OpjournalServiceImpl implements OpjournalService {
    @Resource
    private OpjournalDao opjournalDao;

    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public OpjournalVo setOpjournal(OpjournalVo opjournalVo) {
        opjournalDao.insertOpjournal(opjournalVo);
        return opjournalVo;
    }

    @Override
    public List<OpjournalVo> selectAllOpJ() {
        return opjournalDao.selectAllOpJ();
    }

    @Override
    public List<OpjournalVo> selectOpJByOperator(String operator) {
        return opjournalDao.selectOpJByOperator(operator);
    }

    @Override
    public List<OpjournalVo> selectOpJByOpcontent(String opcontent) {
        return opjournalDao.selectOpJByOpcontent(opcontent);
    }

    @Override
    public List<OpjournalVo> selectOpJByOpTiome(String optiome) {
        return opjournalDao.selectOpJByOpTiome(optiome);
    }

    @Override
    public List<OpjournalVo> selectOpJByOpTiomeAndOperator(String optiome, String operator) {
        return opjournalDao.selectOpJByOpTiomeAndOperator(optiome,operator);
    }

    @Override
    public List<OpjournalVo> selectOpJByOpTiomeAndOpContent(String optiome, String opcontent) {
        return opjournalDao.selectOpJByOpTiomeAndOpContent(optiome,opcontent);
    }


}
