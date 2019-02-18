package com.springboot.demo.application.mod;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 3537921742065870581L;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Date release;
    @Column
    private String des;
    @Column
    private String author;
    @Column
    private Double sal;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", release=" + release +
                ", des='" + des + '\'' +
                ", author='" + author + '\'' +
                ", sal=" + sal +
                '}';
    }
}
