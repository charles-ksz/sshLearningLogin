package com.kevin.dao.impl;

import com.kevin.dao.BorrowInfoDao;
import com.kevin.entity.Borrowinfo;
import com.kevin.entity.User;
import javassist.bytecode.stackmap.BasicBlock;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("BorrowInfoDao") //进行注入
public class BorrowInfoDaoImpl implements BorrowInfoDao {
    @Resource(name="sessionFactory")
    SessionFactory sessionFactory;

    private Borrowinfo borrowinfo;

    public Borrowinfo getBorrowinfo() {
        return borrowinfo;
    }

    public void setBorrowinfo(Borrowinfo borrowinfo) {
        this.borrowinfo = borrowinfo;
    }

    public void delete(long  bookid, String username)
    {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("delete from Borrowinfo b where b.bookid=? and b.username=?");
        query.setParameter(0,bookid);
        query.setParameter(1,username);
        query.executeUpdate();
    }

    public List<Borrowinfo> listBorrowInfo()
    {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Borrowinfo");
        return query.list();
    }
    public Borrowinfo get(long  bookid,String username) {


            System.out.println(bookid);
            System.out.println(username);
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(" from Borrowinfo b where b.bookid=? and b.username=?");
            query.setParameter(0, bookid);
            query.setParameter(1, username);
            borrowinfo = (Borrowinfo) query.list().get(0);
            return borrowinfo;

    }




    public  void  add(long bookid,String username)
    {
        Borrowinfo borrowinfo1=new Borrowinfo();
        System.out.println(username);
            borrowinfo1.setUsername(username);
            System.out.println( borrowinfo1.getUsername()+ " 1");
            borrowinfo1.setBookid(bookid);
            Calendar calendar=Calendar.getInstance();
            Date utilDate=calendar.getTime();
            System.out.println(utilDate);
            java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
            System.out.println(sqlDate);
            borrowinfo1.setBorrowtime(sqlDate);

            calendar.add(Calendar.MONTH,3);
            utilDate=calendar.getTime();
            System.out.println(utilDate);
            sqlDate=new java.sql.Date(utilDate.getTime());
            System.out.println(sqlDate);
            borrowinfo1.setBacktime(sqlDate);

            //0：借出
            borrowinfo1.setIsback(0);
            Session session=sessionFactory.getCurrentSession();
            session.save(borrowinfo1);

    }

    public  void update(Borrowinfo borrowinfo)
    {
        sessionFactory.getCurrentSession().update(borrowinfo);
    }
}
