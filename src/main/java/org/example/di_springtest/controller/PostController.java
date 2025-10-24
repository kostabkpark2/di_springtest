package org.example.di_springtest.controller;

import org.example.di_springtest.dto.PostRequiryDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
  //@Autowired
  private final PostService postService;

  //@Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/list")
  //@ResponseBody
  public  String getAllPosts(Model model) {
    //List<Post> postService.getAllPost();
    model.addAttribute("allPosts", postService.getAllPost());
    return "postAll";
  }

  @GetMapping("/dynamic")
  @ResponseBody
  public List<Post> getAllPostsDynamicCondition(@RequestBody PostRequiryDto postRequiry) {
    return postService.selectAllPostsDynamicCondition(postRequiry);
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

  @GetMapping("/update/{postId}")
  @ResponseBody
  public String updatePost(@PathVariable int postId,
                           @RequestParam String body) {
    Post post = new Post();
    post.setPostId(postId);
    post.setBody(body);
    postService.updatePost(post);
    return postId + "번째 게시판 글이 수정되었습니다.";
  }

  @GetMapping("/delete/{postId}")
  @ResponseBody
  public String deletePost(@PathVariable int postId) {
    postService.deletePost(postId);
    return postId + "번째 게시판 글이 삭제되었습니다.";
  }
}
