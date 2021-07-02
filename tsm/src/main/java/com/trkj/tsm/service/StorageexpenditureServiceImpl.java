package com.trkj.tsm.service;

import com.trkj.tsm.dao.StorageexpenditureDao;
import com.trkj.tsm.entity.Storageexpenditure;
import com.trkj.tsm.util.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StorageexpenditureServiceImpl implements StorageexpenditureService {
    @Resource
    private StorageexpenditureDao storageexpenditureDao;

    @Override
    public List<Storageexpenditure> selectALLstorageex() {
        return storageexpenditureDao.selectALLstorageex();
    }

    @Override
    @Caching(evict = {@CacheEvict( value = "alldepts",allEntries = true)},
            put={@CachePut(value = "storageexpenditure",key = "#storageexpenditure.storageexpenditureId()")})
    public Storageexpenditure addstorageex(Storageexpenditure storageexpenditure) {
        log.debug("新增教材入库收支情况");
        Storageexpenditure storageex=new Storageexpenditure();
        BeanCopyUtil.copyProperties(storageexpenditure,storageex);
        storageex.setAddname("刘小小");
        log.debug(storageex.toString());
        storageexpenditureDao.insertSelective(storageexpenditure);
        return storageex;
    }
}
