package com.epam.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private long id;
    private String title;
    private Date date;
    private String brief;
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

    @DateTimeFormat(pattern = DATE_PATTERN)
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
