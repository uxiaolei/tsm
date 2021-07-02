package com.trkj.tsm.dao;

import com.trkj.tsm.entity.Storageexpenditure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorageexpenditureDao {
    int deleteByPrimaryKey(Integer storageexpenditureId);

    int insert(Storageexpenditure record);

    int insertSelective(Storageexpenditure record);

    Storageexpenditure selectByPrimaryKey(Integer storageexpenditureId);

    int updateByPrimaryKeySelective(Storageexpenditure record);

    int updateByPrimaryKey(Storageexpenditure record);

    List<Storageexpenditure> selectALLstorageex();//显示所有教材收入

}