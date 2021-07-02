package com.trkj.tsm.service;


import com.trkj.tsm.vo.Deliveryddetails;

import java.util.List;

public interface BookdeliveryService {
    List<Deliveryddetails> selectdel();
    Deliveryddetails insertdel(Deliveryddetails deliveryddetails);
    Deliveryddetails deleteByPrimaryKey(Deliveryddetails deliveryddetails);
    List<Deliveryddetails> selectBookdelivery(String bookname);

}
