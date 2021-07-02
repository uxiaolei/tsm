package com.trkj.tsm.service;

import com.trkj.tsm.vo.Bookstorage;

import java.util.List;

public interface BookstorService {
    List<Bookstorage> selectBookstor();

    List<Bookstorage>selectbookname(String bookname);

    List<Bookstorage>selectpress(String press);

    Bookstorage addBookstorage(Bookstorage bookstorage);

    Bookstorage updateByPrimaryKey(Bookstorage bookstorage);

    Bookstorage deleteByPrimaryKey(Bookstorage bookstorage);
}
