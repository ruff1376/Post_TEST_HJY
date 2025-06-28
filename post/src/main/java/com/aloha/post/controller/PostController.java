package com.aloha.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(Model model) throws Exception {
        List<Post> postList = postService.list();
        model.addAttribute("postList", postList);
        return "/Post/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "/Post/read";
    }

    @GetMapping("/insert")
    public String insert() {
        return "/Post/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Post post) throws Exception {
        if (postService.insert(post)) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/insert?error";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model) throws Exception {
        Post post = postService.select(no);
        model.addAttribute("post", post);
        return "/Post/update";
    }
    
    @PostMapping("/update")
    public String updatePro(Post post) throws Exception {
        if (postService.update(post)) {
            return "redirect:/Post/list";
        }
        return "/Post/update";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        if (postService.delete(no)) {
            return "redirect:/Post/list";
        }
        return "redirect:/Post/update?no=" + no + "&error";
    }

}
