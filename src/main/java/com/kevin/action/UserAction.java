package com.kevin.action;

import com.kevin.entity.Book;
import com.kevin.entity.User;

import com.kevin.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;



@Controller("User_")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;

    List<User>  users;






    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    public String edit()
    {
        System.out.println("213231232");
        System.out.println("yonghu"+user.getId());
        user=userService.getUserById(user.getId());
        System.out.println("213213213");
       return  "editUser";
    }



    public String login() {

        if(userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }


    }

    public String getInfo()
    {
        user=userService.getUserByUsername(user.getUsername());
        return "get";
    }

    public String get()
    {
        user=userService.getUserByUsername(user.getUsername());
        return "recompensateAction";
    }
    public String list()
    {
        users=userService.list();
        return "listUser";
    }

    public  String add()
    {
        userService.addUser(user);
        return  "listUserAction";
    }

    public  String delete()
    {
        userService.delete(user.getId());
        return "listUserAction";
    }

    public  String update()
    {
        userService.update(user);
        return "listUserAction";
    }



    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public  String  recompensate()
    {
        userService.recompensate(user.getAllprice(),user.getUsername());
           return SUCCESS;
    }
}

