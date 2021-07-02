package com.trkj.tsm.service;

import com.trkj.tsm.dao.BookbackDao;
import com.trkj.tsm.vo.Bookback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookBackServiceImpl implements com.trkj.tsm.service.BookBackService {
    @Resource
    private BookbackDao bookbackDao;
    @Override
    public List<Bookback> selectback() {

        return bookbackDao.selectback();
    }

    @Override
    public Bookback insertback(Bookback bookback) {
        bookback.setEmpId(1);
        bookback.setStudentId(1);

        bookbackDao.insertback(bookback);
        return bookback;
    }

    @Override
    public Bookback delectback(Bookback bookback) {
        bookback.setTimelinessback(1);
        bookbackDao.updateback(bookback);
        return bookback;
    }

    @Override
    public Bookback updateback(Bookback bookback) {
        bookbackDao.updateback(bookback);
        return bookback;
    }

    @Override
    public List<Bookback> selectbackfy(String value) {
        return bookbackDao.selectbackfy(value);
    }
}
