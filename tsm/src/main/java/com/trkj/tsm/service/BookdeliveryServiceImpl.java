package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookdeliveryDao;
import com.trkj.tsm.dao.DeliveryddetailsDao;

import com.trkj.tsm.vo.Deliveryddetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BookdeliveryServiceImpl implements com.trkj.tsm.service.BookdeliveryService {
    @Resource
    private DeliveryddetailsDao deliveryddetailsDao;
    @Resource
    private BookdeliveryDao bookdeliveryDao;
    @Override
    public List<Deliveryddetails> selectdel() {
        return deliveryddetailsDao.selectdel();

    }

    @Override
    public Deliveryddetails insertdel(Deliveryddetails deliveryddetails) {
//        deliveryddetails.setDeliverycount(1);


        deliveryddetails.setEmpId(1);
//        deliveryddetails.setStudentId(1);
        deliveryddetailsDao.insertdel(deliveryddetails);
        return deliveryddetails;

    }

    @Override
    public Deliveryddetails deleteByPrimaryKey(Deliveryddetails deliveryddetails) {
        deliveryddetails.setTimelinessdel(1);
        deliveryddetails.setDeliverycount(30);
        deliveryddetails.setReceivablemoney(BigDecimal.ONE);
        deliveryddetailsDao.updateByPrimaryKey(deliveryddetails);
        return deliveryddetails;
    }

    @Override
    public List<Deliveryddetails> selectBookdelivery(String value) {
        return deliveryddetailsDao.selectBookdelivery(value);
    }

//    @Override
//    public Bookdelivery deleteByPrimaryKey(Bookdelivery bookdelivery) {
//        bookdelivery.setTimeliness(1);
//        bookdelivery.setDeletetime(new Date());
//       bookdeliveryDao.updateByPrimaryKey(bookdelivery);
//       return bookdelivery;
//    }

//    @Override
//    public Deliveryddetails selectdel1() {
//        return deliveryddetailsDao.selectdel1();
//    }
}
