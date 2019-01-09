package com.kevin.action;


import com.kevin.entity.User;
import com.kevin.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;


@Controller("userRegisterAction")
@Scope("prototype")
public class UserRegisterAction  extends ActionSupport implements ServletResponseAware {
    @Resource
    private UserService userService;
    private User user;
    private javax.servlet.http.HttpServletResponse response;
    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public String register ()
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out = null;
        System.out.println("register");
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userService.addUser(user))
        {
            System.out.println("1232133");
            Map session =ActionContext.getContext().getSession();
            session.put("user",user);
            out.print("<script>alert('注册成功！')</script>");
            out.print("<script>window.location.href='index.jsp '</script>");
            out.flush();
            out.close();
            return SUCCESS;
        }
        else {
            return  ERROR;
        }
    }
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}

