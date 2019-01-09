package com.kevin.dao;


import com.kevin.entity.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getByInfo(String name, String author, String publisher);
    public  void  delete(long  bookid);
    public  List<Book> listBook();
    public Book get(long  bookid);
    public void add(Book book);
    public void delete(Book book);
    public void update(Book book);
}
