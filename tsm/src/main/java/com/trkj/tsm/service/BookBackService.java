package com.trkj.tsm.service;

import com.trkj.tsm.vo.Bookback;

import java.util.List;

public interface BookBackService {
    List<Bookback> selectback();
    Bookback insertback(Bookback bookback);
    Bookback delectback(Bookback bookback);
    Bookback updateback(Bookback bookback);
    List<Bookback> selectbackfy( String bookname);
}
