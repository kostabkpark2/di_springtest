package org.example.di_springtest.controller;

import org.example.di_springtest.model.Post;
import org.example.di_springtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ditest")
public class PostController {
  //@Autowired
  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/list")
  @ResponseBody
  public List<Post> getAllPosts() {
    return postService.getAllPost();
  }

  @GetMapping("/insert")
  @ResponseBody
  public String createPost(@RequestParam String title,
                           @RequestParam String body) {
    Post post = new Post();
    post.setTitle(title);
    post.setBody(body);
    String msg = postService.createPost(post) + "번째 게시판 글이 등록되었습니다.";
    return msg;
  }
}
