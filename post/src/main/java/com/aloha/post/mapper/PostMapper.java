package com.aloha.post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.post.dto.Page;
import com.aloha.post.dto.Post;

@Mapper
public interface PostMapper {
    
    // 게시글 목록
    public List<Post> list() throws Exception;
    // 페이징 목록
    public List<Post> pagingList(Page page) throws Exception;
    // 데이터 수
    public long count() throws Exception;
    // 게시글 조회
    public Post select(Integer no) throws Exception;
    // 게시글 등록
    public int insert(Post post) throws Exception;
    // 게시글 수정
    public int update(Post post) throws Exception;
    // 게시글 삭제
    public int delete(Integer no) throws Exception;

}
