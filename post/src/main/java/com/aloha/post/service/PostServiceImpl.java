package com.aloha.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.post.dto.Post;
import com.aloha.post.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Post> list() throws Exception {
        List<Post> postList = postMapper.list();
        return postList;
    }

    @Override
    public Post select(Integer no) throws Exception {
        Post post = postMapper.select(no);
        return post;
    }

    @Override
    public boolean insert(Post post) throws Exception {
        return postMapper.insert(post) > 0;
    }

    @Override
    public boolean update(Post post) throws Exception {
        return postMapper.update(post) > 0;
    }

    @Override
    public boolean delete(Integer no) throws Exception {
        return postMapper.delete(no) > 0;
    }
    
}
