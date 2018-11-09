package com.epam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="NEWS")
public class News {
    @Id
    private long id;

    @Column(name="TITLE")
    @Size(min=2, max=60, message="{validation.title.size}")
    private String title;

    @Column(name="NEWS_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message="{validation.date.past}")
    private Date date;

    @Column(name="BRIEF")
    @Size(min=2, max=200, message="{validation.brief.size}")
    private String brief;

    @Column(name="CONTENT")
    @Size(min=2, max=2000, message="{validation.content.size}")
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
