package com.aloha.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.aloha.post.dto.Page;
import com.aloha.post.dto.Post;
import com.aloha.post.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/Post")
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public String list(Model model, Page page) throws Exception {
        List<Post> postList = postService.pagingList(page);
        model.addAttribute("page", page);
        model.addAttribute("postList", postList);

        String pageUri = UriComponentsBuilder.fromPath("/Post/list")
                                             .queryParam("size", page.getSize())
                                             .queryParam("count", page.getCount())
                                             .build()
                                             .toUriString();
        model.addAttribute("pageUri", pageUri);

        return "Post/list";
    }
    
    @GetMapping("/read/{no}")
    public String read(@PathVariable("no") Integer no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "Post/read";
    }

    @GetMapping("/insert")
    public String insert(@ModelAttribute(value = "post") Post post) {
        return "Post/insert";
    }

    @PostMapping(path = "/insert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String insertPost(Post post) throws Exception {
        if (postService.insert(post)) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/insert?error";
    }
    
    @GetMapping("/update/{no}")
    public String update(@PathVariable("no") Integer no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "Post/update";
    }
    
    @PostMapping("/update")
    public String updatePost(Post post) throws Exception {
        if (postService.update(post)) {
            return "redirect:/Post/list";
        }
        return "/Post/update?error";
    }
    
    @PostMapping("/delete/{no}")
    public String deletePost(@PathVariable("no") Integer no) throws Exception {
        if (postService.delete(no)) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/update?error";
    }

}
