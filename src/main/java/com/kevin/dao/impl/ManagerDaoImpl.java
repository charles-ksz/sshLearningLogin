package com.kevin.dao.impl;

import com.kevin.dao.ManagerDao;
import com.kevin.entity.Manager;
import com.kevin.entity.User;
import com.sun.net.httpserver.Authenticator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.Iterator;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;


@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("managerDao") //进行注入
public class ManagerDaoImpl  implements ManagerDao{
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;


    public String  login(Manager manager)
    {
        Iterator<Manager> it;
        String hsql="FROM Manager u where u.username=? and u.pwd=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, manager.getUsername());
        query.setString(1, manager.getPwd());
        System.out.println(manager.getUsername());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return SUCCESS;
        } else {
            System.out.println("false");
            return ERROR;
        }
    }
    public  void  update( Manager manager)
    {
        System.out.println(manager.getId());
        System.out.println(manager.getUsername());
        System.out.println(manager.getPwd());
        sessionFactory.getCurrentSession().update(manager);
    }
    public void edit(Manager manager)
    {
        ///
    }

    public Manager get(int id)
    {
        return (Manager) sessionFactory.getCurrentSession().get(Manager.class,id);
    }

    @Override
    public Manager getByInfo(String username) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Manager m where m.username=?");
        query.setParameter(0,username);
       return (Manager) query.list().get(0);
    }
}
