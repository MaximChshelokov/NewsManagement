package com.epam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="NEWS")
public class News {
    @Id
    private long id;
    @Column(name="TITLE")
    private String title;
    @Column(name="NEWS_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name="BRIEF")
    private String brief;
    @Column(name="CONTENT")
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
