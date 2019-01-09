package com.kevin.dao.impl;



import com.kevin.dao.BookDao;
import com.kevin.entity.Book;
import com.kevin.entity.User;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("BookDao") //进行注入
public class BookDaoImpl implements BookDao{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private String name;
    private  String publisher;
    private String author;
    private  Book book;
    private  String username;
    private  List<Book> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Override
    public List<Book> getByInfo(String name, String author, String publisher) {


        Session session=sessionFactory.getCurrentSession();

        StringBuffer hql= new StringBuffer();

             hql.append(  "from Book b where 1=1 ");


        if (name.length()!=0) {

            hql.append("and b.name like '%").append(name).append("%'");
        }

        if (author.length()!=0)
            hql.append("and b.author like '%" + author + "%'");

        if (publisher.length()!=0)
            hql.append("and b.publisher like '%"+publisher+"%'") ;


        Query query=session.createQuery(hql.toString());

       list=query.list();

        return list;
    }





    public void delete(long bookid)
    {

        Session session=sessionFactory.getCurrentSession();
        String hql="delete from Book b where b.bookid=?";
        Query query=session.createQuery(hql);
        query.setParameter(0 ,bookid) ;
        query.executeUpdate();

    }

    public List<Book> listBook()
    {
        System.out.println("110");
        try{
            Session session=sessionFactory.getCurrentSession();
            Query query= session.createQuery("from Book");
            System.out.println("111");
             list = query.list();

             System.out.println("112");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("!!!"+list.get(0).getAuthor());
        return  list;
    }


    public Book get(long  bookid)
    {
        System.out.println("b1");
        System.out.println(bookid);
       Session session=sessionFactory.getCurrentSession();
       Query query=session.createQuery("from Book b where b.bookid=?");
       query.setParameter(0,bookid);
        return (Book) query.list().get(0);
    }

    public void add(Book book)
    {
        System.out.println(book.getId());
        Session session=sessionFactory.getCurrentSession();

        session.save(book);
//        Query query=session.createQuery("select ifnull(b.mount,0) from Book b");
        System.out.println(
                "tushu"+book.getId());
        System.out.println("addbook success");
    }

    public void delete(Book book)
    {
        Session session=sessionFactory.getCurrentSession();
        session.delete(book);

    }

    public void update(Book  book)
    {
        Session session=sessionFactory.getCurrentSession();
        session.update(book);
        System.out.println("updatebook success");
    }
}
