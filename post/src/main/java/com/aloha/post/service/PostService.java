package com.aloha.post.service;

import java.util.List;

import com.aloha.post.dto.Post;

public interface PostService {

    // 게시글 목록
    public List<Post> list() throws Exception;
    // 게시글 조회
    public Post select(int no) throws Exception;
    // 게시글 등록
    public boolean insert(Post post) throws Exception;
    // 게시글 수정
    public boolean update(Post post) throws Exception;
    // 게시글 삭제
    public boolean delete(int no) throws Exception;
    
}
