package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookdeliveryDao;
import com.trkj.tsm.vo.Bookdelivery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookBydeImpl implements BookByde {
    @Resource
    private BookdeliveryDao bookdeliveryDao;
    @Override
    public List<Bookdelivery> selectByde() {
        return bookdeliveryDao.selectByde();
    }
}
