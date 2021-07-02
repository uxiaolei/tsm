package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookdeliveryDao;
import com.trkj.tsm.vo.Bookdelivery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class BookdeliverysImpl implements com.trkj.tsm.service.Bookdeliverys {
    @Resource
    private BookdeliveryDao bookdeliveryDao;

    @Override
    public Bookdelivery deleteByPrimaryKey(Bookdelivery bookdelivery) {
        bookdelivery.setTota(BigDecimal.ONE);
        bookdelivery.setTimeliness(1);
        bookdeliveryDao.updateByPrimaryKey(bookdelivery);
         return bookdelivery;
    }

    @Override
    public Bookdelivery insert(Bookdelivery bookdelivery) {
        bookdelivery.setEmpId(1);
//        bookdelivery.setStudentId(1);
        bookdelivery.setDeliverytime(new Date());
        bookdeliveryDao.insert(bookdelivery);
        return bookdelivery;
    }
}
