package com.trkj.tsm.service;

import com.trkj.tsm.entity.Storageexpenditure;

import java.util.List;

public interface StorageexpenditureService {
    List<Storageexpenditure> selectALLstorageex();//显示所有教材收入
    Storageexpenditure addstorageex(Storageexpenditure storageexpenditure);//新增教材入库收支
}
