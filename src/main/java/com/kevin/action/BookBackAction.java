package com.kevin.action;

import com.kevin.entity.Borrowinfo;
import com.kevin.service.BorrowinfoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import java.io.IOException;
import java.io.PrintWriter;

@Scope("prototype")
@Controller("bookBackAction")
public class BookBackAction extends ActionSupport implements ServletResponseAware{
    @Resource
    private BorrowinfoService borrowinfoService;

    private javax.servlet.http.HttpServletResponse response;

    private Borrowinfo borrowinfo;

    public Borrowinfo getBorrowinfo() {
        return borrowinfo;
    }

    public void setBorrowinfo(Borrowinfo borrowinfo) {
        this.borrowinfo = borrowinfo;
    }


    public  String backBook1()
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码

        System.out.println("222");
        System.out.println(borrowinfo.getUsername());
        borrowinfoService.delete(borrowinfo.getBookid(),borrowinfo.getUsername());
        try {
            PrintWriter out = response.getWriter();

            out.print("<script>alert('还书成功！')</script>");
            out.print("<script>window.location.href='success.jsp '</script>");   out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  SUCCESS;
    }

    // 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
