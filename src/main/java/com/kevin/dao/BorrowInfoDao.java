package com.kevin.dao;


import com.kevin.entity.Borrowinfo;

import java.util.List;

public interface BorrowInfoDao {


    public void delete(long  bookid,String username);
    public List<Borrowinfo> listBorrowInfo();
    public Borrowinfo get(long  bookid,String username);
    public  void  add(long bookid,String username);
    public  void update(Borrowinfo borrowinfo);


}
