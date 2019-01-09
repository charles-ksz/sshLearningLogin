package com.kevin.action;


import com.kevin.entity.Borrowinfo;
import com.kevin.entity.User;
import com.kevin.service.BorrowinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.struts2.interceptor.ServletResponseAware;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@Scope("prototype")
@Controller("bookBorrowAction")

public class BookBorrowAction extends ActionSupport implements ServletResponseAware {
    @Resource
    private  BorrowinfoService borrowinfoService;
    private javax.servlet.http.HttpServletResponse response;
   private Borrowinfo borrowinfo;
   private  String username;
   private  long bookid;
    private  String type;
    private  User user;

    private String tem="操作成功";
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public Borrowinfo getBorrowinfo() {
        return borrowinfo;
    }

    public void setBorrowinfo(Borrowinfo borrowinfo) {
        System.out.println("ba132146");
        this.borrowinfo = borrowinfo;
    }



    public String    borrow()
    {
        System.out.println(borrowinfo.getUsername());
        System.out.println(borrowinfo.getBookid());
//        borrowinfo.setUsername(username);
//        borrowinfo.setBookid(bookid);
        System.out.println("bab132146");
       String result= borrowinfoService.add(borrowinfo.getBookid(),borrowinfo.getUsername());
        System.out.println(result);
       if(result.equals("deal1"))
       {
           tem="借书超期未归还，请先还书";

       }
       else if(result.equals("deal2"))
       {
           tem="请先支付赔偿";
       }

       else  if(result.equals("deal3"))
       {
           tem="库存暂无，敬请期待";
       }
       System.out.println(tem);
        print(tem);
        System.out.println(1212);
       return SUCCESS;
    }

    public String reBorrowBook()
    {
        borrowinfoService.reBorrow(borrowinfo.getBookid(),borrowinfo.getUsername());
        print(tem);
        return  "operate";
    }

    public  String compensate(){

        HttpServletRequest request= ServletActionContext.getRequest();
        String cType=request.getParameter("type");
        System.out.println("leix  :"+type);
        System.out.println(borrowinfo.getUsername());
        borrowinfoService.compensate(type,borrowinfo.getUsername(),borrowinfo.getBookid());

        print(tem);
        return  "compensate1";

    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    private void print(String tem)
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>alert('" + tem + "')</script>");
            System.out.println("print"+tem);
            out.print("<script>window.location.href='success.jsp '</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
