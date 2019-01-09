package com.kevin.action;

import org.apache.struts2.interceptor.ServletResponseAware;
import com.kevin.entity.Book;
import com.kevin.entity.Borrowinfo;
import com.kevin.entity.User;
import com.kevin.service.BookService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller("BookAction")
@Scope("prototype")
public class BookAction implements ServletResponseAware{

    @Resource(name="bookService")
    private BookService bookService;
    private Book book;
    private Borrowinfo borrow;
    private javax.servlet.http.HttpServletResponse response;


    private List<Book> books;
    private String username;
    private  User user;


    // 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    public Borrowinfo getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrowinfo borrow) {
        this.borrow = borrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        System.out.println("132142");
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        System.out.println("132146");
        this.user = user;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("132143");
        this.username=username;

    }



    public List<Book> getBooks() {
        System.out.println("2");
        return books;
    }

    public void setBooks(List<Book> books) {
        System.out.println("132144");
        this.books = books;
    }



    //select book
    public String select()
    {
        System.out.println("3");


      books=bookService.getByInfo(book.getName(),book.getAuthor(),book.getPublisher());
      System.out.println(books.get(0).getAuthor());
        return SUCCESS;
    }

    //select book by bookid
    public String getById(int bookid)
    {

        System.out.println("4");
        bookService.get(bookid);

        return SUCCESS;
    }

    //show all book
    public  String list()
    {
        System.out.println("5");
        books=bookService.list();

        System.out.println("9");
        return  "listBook";
    }

    public  String mList()
    {
        System.out.println("5");
        books=bookService.list();

        System.out.println("9");
        return  "mListBook";
    }
    // add book
    public  String add()
    {
        System.out.println("6");
        bookService.add(book);
        print();
        return "listBookAction";
    }


    //edit  book
    public String edit()
    {
        System.out.println();
        book=bookService.get(book.getBookid());
        print();
        return  "editBook";
    }

    public String delete(){
        bookService.delete(book.getBookid());
        print();
        return  "listBookAction";
    }

    public String update()
    {
        System.out.println("7");
        bookService.update(book);

        return  "listBookAction";
    }
    private void print()
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>alert('操作成功！')</script>");
            out.print("<script>window.location.href='successManage.jsp '</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
