package com.kevin.service;

import com.kevin.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getByInfo(String name, String author, String type);
    public Book get(long bookid);
    public List<Book> list();

    public void add(Book book);
    public void update(Book  book);
    public  void  delete(long bookid);
}
