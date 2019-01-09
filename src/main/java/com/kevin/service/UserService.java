package com.kevin.service;

import com.kevin.entity.User;

import java.math.BigDecimal;
import java.util.List;


public interface UserService {
    public boolean addUser(User user);

    public boolean login(User user);

    public List<User> list();

    public User getUserById(int id);

    public void update(User user);

    public boolean delete(int id);

    public User getUserByUsername(String username);
    public void recompensate(BigDecimal allprice,String username);



}

