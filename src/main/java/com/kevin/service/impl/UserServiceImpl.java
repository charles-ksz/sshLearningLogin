package com.kevin.service.impl;

import com.kevin.dao.BookDao;
import com.kevin.dao.UserDao;
import com.kevin.entity.User;
import com.kevin.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
//注入服务
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService{
    //自动注入userDao，也可以使用@Autowired
    @Resource(name="userDao")
    private UserDao userDao;



    @Override
    public boolean addUser(User user) {
        System.out.println("21321");
        user.setAllprice( new BigDecimal("0"));
        user.setIsback(0);
        user.setNum(0);
        this.userDao.add(user);

        return true;
    }

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> list() {
        return this.userDao.getUser();
    }

    @Override
    public User getUserById(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    public void update(User user) {
        this.userDao.update(user);
    }

    @Override
    public boolean delete(int id) {
        this.userDao.delete(id);
        return true;
    }




    public User getUserByUsername(String username)
    {
        return userDao.getUserByInfo(username);

    }


    public  void  recompensate(BigDecimal allprice,String username)
    {
        userDao.getUserByInfo(username).setAllprice(allprice);
    }
}

