package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Opjournal;
import com.trkj.tsm.vo.OpjournalVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface OpjournalDao {
    int deleteByPrimaryKey(Integer opjournalId);

    int insert(Opjournal record);

    int insertSelective(Opjournal record);

    Opjournal selectByPrimaryKey(Integer opjournalId);

    int updateByPrimaryKeySelective(Opjournal record);

    int updateByPrimaryKey(Opjournal record);

    /**
     * 新增操作日志
     *
     * @param opjournalVo
     * @return
     */
    int insertOpjournal(OpjournalVo opjournalVo);

    /**
     * 查询所有操作日志
     *
     * @return
     */
    List<OpjournalVo> selectAllOpJ();

    /**
     * 根据条件模糊查询：操作人、操作内容、操作时间
     *
     * @return
     */
    List<OpjournalVo> selectOpJByOperator(String operator);

    List<OpjournalVo> selectOpJByOpcontent(String opcontent);

    List<OpjournalVo> selectOpJByOpTiome(String optiome);

    /**
     * 根据多条件模糊查询：操作时间加操作人、操作时间加操作内容
     * @param optiome
     * @param operator
     * @return
     */
    List<OpjournalVo> selectOpJByOpTiomeAndOperator(String optiome,String operator);

    List<OpjournalVo> selectOpJByOpTiomeAndOpContent(String optiome,String opcontent);
}