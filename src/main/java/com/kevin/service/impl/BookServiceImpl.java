package com.kevin.service.impl;

import com.kevin.dao.BookDao;
import com.kevin.entity.Book;
import com.kevin.service.BookService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
@Service("bookService")
@Scope("prototype")
public class BookServiceImpl implements BookService {

    @Resource(name="BookDao")
    private BookDao bookDao;

    @Override
    public List<Book> getByInfo(String name, String author, String publisher)
    {

        System.out.println("224");

        return  bookDao.getByInfo(name,author,publisher);
    }

    @Override
    public Book get(long bookid)
    {
        return bookDao.get(bookid);
    }

    @Override
    public  void add(Book book)
    {
        book.setMount(book.getAllmount());
        bookDao.add(book);
    }

    @Override
    public List<Book> list()
    {
        List<Book> books=bookDao.listBook();
        System.out.println("123");
        if (books.isEmpty())
        {
            for (int i=0;i<2;i++)
            {
                Book book=new Book();
                book.setName("book"+i);
                bookDao.add(book);
                books.add(book);
            }
        }

        return  books;
    }

    public void delete(Book book)
    {
        bookDao.delete(book);
    }
    public void update(Book  book)
    {
        bookDao.update(book);
    }
    public  void  delete(long bookid){
        bookDao.delete(bookid);
    }

}
