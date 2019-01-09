package com.kevin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="borrowinfo")
public class Borrowinfo {
    private int id;
    private Long bookid;
    private String username;
    private Date borrowtime;
    private Date backtime;
    private Integer isback;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bookid")
    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "borrowtime")
    public Date getBorrowtime() {
        return borrowtime;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    @Basic
    @Column(name = "backtime")
    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    @Basic
    @Column(name = "isback")
    public Integer getIsback() {
        return isback;
    }

    public void setIsback(Integer isback) {
        this.isback = isback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Borrowinfo that = (Borrowinfo) o;

        if (id != that.id) return false;
        if (bookid != null ? !bookid.equals(that.bookid) : that.bookid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (borrowtime != null ? !borrowtime.equals(that.borrowtime) : that.borrowtime != null) return false;
        if (backtime != null ? !backtime.equals(that.backtime) : that.backtime != null) return false;
        if (isback != null ? !isback.equals(that.isback) : that.isback != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookid != null ? bookid.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (borrowtime != null ? borrowtime.hashCode() : 0);
        result = 31 * result + (backtime != null ? backtime.hashCode() : 0);
        result = 31 * result + (isback != null ? isback.hashCode() : 0);
        return result;
    }
}
