package com.kevin.dao;

import com.kevin.entity.Manager;
import com.kevin.entity.User;

public interface ManagerDao {

    public String  login(Manager manager);
    public  void  update( Manager manager);
    public  void edit(Manager manager);
    public Manager get(int id);

    public  Manager getByInfo(String username);

}
