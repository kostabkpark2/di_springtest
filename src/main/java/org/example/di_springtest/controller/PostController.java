package org.example.di_springtest.controller;

import org.example.di_springtest.dto.PostRequiryDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
  //@ResponseBody
  public String getAllPostsDynamicCondition(@ModelAttribute PostRequiryDto postRequiry,
                                                Model model) {
    model.addAttribute("allPosts", postService.selectAllPostsDynamicCondition(postRequiry));
    return "postAll";
  }

  @GetMapping("/insert")
  //@ResponseBody
  public String createPost() {
    // 로그인 여부 체크
    return "postAdd";
  }

  @PostMapping("/insert")
  public String createPost(Model model, Post post) {
    // 로그인 여부 체크
    postService.createPost(post);
    return "redirect:/posts/list";
  }

  @GetMapping("/update/{postId}")
  public String updatePost(@PathVariable int postId,  Model model) {
    // 로그인 여부 체크
    Post post = postService.selectPost(postId);
    model.addAttribute("post", post);
    return "postUpdate";
  }

  @PostMapping("/update/{postId}")
  public String updatePost(@PathVariable int postId,
                           Post post) {
    // 로그인 여부 체크
    Post post1 = postService.selectPost(postId);
    post1.setBody(post.getBody());
    postService.updatePost(post1);
    return "redirect:/posts/"+postId;
  }

  @GetMapping("/delete/{postId}")
  //@ResponseBody
  public String deletePost(@PathVariable int postId) {
    // 로그인 여부 체크
    postService.deletePost(postId);
    return "redirect:/posts/list";
  }

  @GetMapping("/{postId}")
  public String getPostById(@PathVariable int postId, Model model) {
    // 로그인 여부 체크
    Post post = postService.selectPost(postId);
    model.addAttribute("post", post);
    return "postDetail";
  }
}
