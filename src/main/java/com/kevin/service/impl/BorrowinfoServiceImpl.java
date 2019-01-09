package com.kevin.service.impl;

import com.kevin.dao.BookDao;
import com.kevin.dao.BorrowInfoDao;
import com.kevin.dao.UserDao;
import com.kevin.entity.Borrowinfo;

import com.kevin.service.BorrowinfoService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;


@Scope("prototype")
@Service("borrowinfoService")
@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
public class BorrowinfoServiceImpl implements BorrowinfoService {

    @Resource(name="BorrowInfoDao")
   private BorrowInfoDao borrowInfoDao;
    private Borrowinfo borrowinfo;


    @Resource
   private UserDao userDao;

    @Resource(name="BookDao")
    private  BookDao bookDao;

    public Borrowinfo getBorrowinfo() {
        return borrowinfo;
    }

    public void setBorrowinfo(Borrowinfo borrowinfo) {
        this.borrowinfo = borrowinfo;
    }

    //还书
    public void delete(long bookid,String username)
    {
        System.out.println("123123" +bookid);
        System.out.println("us" +username);
        System.out.println(userDao.getUserByInfo(username).getNum());
        userDao.getUserByInfo(username).setNum(userDao.getUserByInfo(username).getNum()-1);
        System.out.println(userDao.getUserByInfo(username).getNum()+"借书结果用户");

        System.out.println(bookDao.get(bookid).getMount());
        bookDao.get(bookid).setMount( bookDao.get(bookid).getMount()+1);
        System.out.println(bookDao.get(bookid).getMount()+ "借书结果书");

        borrowInfoDao.delete(bookid,username);
        System.out.println("delete ");
    }
    public List<Borrowinfo> listBorrowInfo()
    {
        return   borrowInfoDao.listBorrowInfo();
    }
    public Borrowinfo get(long bookid,String username)
    {
        return  borrowInfoDao.get(bookid,username);
    }
    //借书
    public  String  add(long bookid,String username)
    {
        if(userDao.getUserByInfo(username).getIsback()==1)
        {
                return "deal1";
        }
        if(userDao.getUserByInfo(username).getAllprice().doubleValue()!=0)
        {
            return "deal2";

        }
        if(bookDao.get(bookid).getMount()==0)
        {
            return "deal3";
        }
        userDao.getUserByInfo(username).setNum(userDao.getUserByInfo(username).getNum()+1);

        System.out.println(userDao.getUserByInfo(username).getNum()+"借书结果用户");

        System.out.println(bookDao.get(bookid).getMount());
        bookDao.get(bookid).setMount( bookDao.get(bookid).getMount()-1);
        System.out.println(bookDao.get(bookid).getMount()+ "借书结果书");
        borrowInfoDao.add(bookid,username);
        System.out.println("add ");
        return SUCCESS;
    }

    public  void update(Borrowinfo borrowinfo)
    {
        borrowInfoDao.update(borrowinfo);
    }

    public  void reBorrow(long bookid,String username)
    {
        Date date=borrowInfoDao.get(bookid,username).getBacktime();
        java.util.Date utilDate=new java.util.Date(date.getTime());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(utilDate);
        calendar.add(Calendar.MONTH,3);
        utilDate=calendar.getTime();
        date= new java.sql.Date(utilDate.getTime());
        borrowInfoDao.get(bookid,username).setBacktime(date);
    }

    public  String compensate(String cType, String username,long  bookid)
    {
        BigDecimal price= bookDao.get(bookid).getPrice();
        BigDecimal rate=new BigDecimal("0.7");
        if (userDao.getUserByInfo(username).getAllprice()==null)
        {
            userDao.getUserByInfo(username).setAllprice( new BigDecimal("0"));
        }
        if(cType.equals("0"))
        {
            userDao.getUserByInfo(username).setIsback(1);
            return "deal1";
        }
        else if(cType.equals("1"))
        {
            price=price.multiply(rate).add(userDao.getUserByInfo(username).getAllprice());
            userDao.getUserByInfo(username).setAllprice(price);
            return  "deal2";
        }
        else {

            //库存-1，用户借阅减1，删除记录
             userDao.getUserByInfo(username).setNum(  userDao.getUserByInfo(username).getNum()-1);
             bookDao.get(bookid).setAllmount(  bookDao.get(bookid).getAllmount()-1);
             borrowInfoDao.delete(bookid, username);
            userDao.getUserByInfo(username).setAllprice(bookDao.get(bookid).getPrice());
            return  "deal3";
        }

    }

}
