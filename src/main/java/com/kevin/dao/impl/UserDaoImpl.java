package com.kevin.dao.impl;

import com.kevin.dao.UserDao;
import com.kevin.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("userDao") //进行注入
public class UserDaoImpl  implements UserDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private  User user;



    @Override
    public void add(User user) {
        try{
            System.out.println("21321");

            System.out.println(user.getUsername());
            Session session=sessionFactory.getCurrentSession();
            session.save(user);
           System.out.println(user.getId());
           System.out.println(user.getUsername());
              }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public boolean login(User user) {
        Iterator<User> it;
        String hsql="FROM User u where u.username=? and u.password=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getUsername());
        query.setString(1, user.getPassword());
        System.out.println(user.getUsername());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public User getUser(int id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User user) {



        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class, id)
        );
    }
    @Override
    public  User getUserByInfo(String username)
    {
        System.out.println(username);
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from User u where u.username= ?");
        query.setParameter(0,username);


       return  (User) query.list().get(0);





    }

//    public  void delete(User user)
//    {
//        Session session =sessionFactory.getCurrentSession();
//        Query query=session.createQuery("delete from User u where u." )
//    }

//    public User getUserByUsername(String username)
//    {
//      Query query=  sessionFactory.getCurrentSession().createQuery("from User u where u.username=?");
//        query.setParameter(0,username);
//        List<User> list=query.list();
//        user=list.get(0);
//        return  user;
//    }
}

