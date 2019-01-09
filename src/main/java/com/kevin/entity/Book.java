package com.kevin.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="book")
public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private Long bookid;
    private String type;
    private Integer allmount;
    private Integer mount;
    private BigDecimal price;
    private String remark;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "allmount")
    public Integer getAllmount() {
        return allmount;
    }

    public void setAllmount(Integer allmount) {
        this.allmount = allmount;
    }

    @Basic
    @Column(name = "mount")
    public Integer getMount() {
        return mount;
    }

    public void setMount(Integer mount) {
        this.mount = mount;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        if (bookid != null ? !bookid.equals(book.bookid) : book.bookid != null) return false;
        if (type != null ? !type.equals(book.type) : book.type != null) return false;
        if (allmount != null ? !allmount.equals(book.allmount) : book.allmount != null) return false;
        if (mount != null ? !mount.equals(book.mount) : book.mount != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (remark != null ? !remark.equals(book.remark) : book.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (bookid != null ? bookid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (allmount != null ? allmount.hashCode() : 0);
        result = 31 * result + (mount != null ? mount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
