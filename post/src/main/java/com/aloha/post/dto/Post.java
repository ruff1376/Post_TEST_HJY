package com.aloha.post.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
    private int no;
    private String id;    
    private String title;
    private String writer;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
