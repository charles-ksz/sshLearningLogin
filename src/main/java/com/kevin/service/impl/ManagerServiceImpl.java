package com.kevin.service.impl;

import com.kevin.dao.ManagerDao;
import com.kevin.dao.UserDao;
import com.kevin.entity.Manager;
import com.kevin.entity.User;
import com.kevin.service.ManagerService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Scope("prototype")
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
    @Resource
    ManagerDao managerDao;
    public  String login(Manager manager)
    {
        return  managerDao.login(manager);
    }
    public  void update(Manager manager)
    {

        System.out.println(manager.getId());
        System.out.println(manager.getUsername());
        System.out.println(manager.getPwd());
        managerDao.update(manager);
    }

    public Manager get(int id)
    {
        return managerDao.get(id);
    }

    public  void  edit(Manager manager)
    {
        managerDao.edit(manager);
    }

    @Override
    public Manager getByinfo(String username) {
        return managerDao.getByInfo(username);
    }
}
