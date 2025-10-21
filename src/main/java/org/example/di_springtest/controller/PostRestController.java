package org.example.di_springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
public class PostRestController {
  private final PostService postService;

  @GetMapping("/posts")
  public List<Post> getAllPosts() {
    return postService.getAllPost();
  }

  @PostMapping("/posts")
  public String getAllPosts(@RequestBody Post postDto) {
    Post post = new Post();
    post.setTitle(postDto.getTitle());
    post.setBody(postDto.getBody());
    String msg = postService.createPost(post) + "번째 게시판 글이 등록되었습니다.";
    return msg;
  }

  @PatchMapping("/posts/{postId}")
  public String updatePost(@PathVariable int postId,
                           @RequestBody Post postDto) {
    Post post = new Post();
    post.setPostId(postId);
    post.setBody(postDto.getBody());
    postService.updatePost(post);
    return postId + "번째 게시판 글이 수정되었습니다.";
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable int postId) {
    postService.deletePost(postId);
    return postId + "번째 게시판 글이 삭제되었습니다.";
  }

  @GetMapping("/posts/{postId}")
  public Post getOnePost(@PathVariable int postId) {
    return postService.selectPost(postId);
  }

}
