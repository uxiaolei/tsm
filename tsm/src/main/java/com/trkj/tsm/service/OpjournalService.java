package com.trkj.tsm.service;

import com.trkj.tsm.vo.OpjournalVo;

import java.util.Date;
import java.util.List;

public interface OpjournalService {
    OpjournalVo setOpjournal(OpjournalVo opjournalVo);

    List<OpjournalVo> selectAllOpJ();

    List<OpjournalVo> selectOpJByOperator(String operator);

    List<OpjournalVo> selectOpJByOpcontent(String opcontent);

    List<OpjournalVo> selectOpJByOpTiome(String optiome);

    List<OpjournalVo> selectOpJByOpTiomeAndOperator(String optiome,String operator);

    List<OpjournalVo> selectOpJByOpTiomeAndOpContent(String optiome,String opcontent);
}
