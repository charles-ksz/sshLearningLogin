package com.kevin.service;

import com.kevin.entity.Borrowinfo;

import java.math.BigDecimal;
import java.util.List;

public interface BorrowinfoService {
    public void delete(long bookid,String username);
    public List<Borrowinfo> listBorrowInfo();
    public Borrowinfo get(long bookid,String username);
    public  String  add(long bookid,String username);
    public  void update(Borrowinfo borrowinfo);
    public  void reBorrow(long bookid,String username);
    public  String compensate(String cType, String username,long bookid);
}
