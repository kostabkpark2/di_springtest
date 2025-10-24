package org.example.di_springtest.controller;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.dto.PostAllResponseDto;
import org.example.di_springtest.dto.PostCreateRequestDto;
import org.example.di_springtest.dto.PostDetailResponseDto;
import org.example.di_springtest.dto.PostUpdateRequestDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.service.PostDtoService;
import org.example.di_springtest.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
public class PostRestDtoController {
  private final PostDtoService postService;

  @GetMapping("/posts")
  public List<PostAllResponseDto> viewAllPosts() {
    return postService.getAllPost();
  }

  @PostMapping("/posts")
  public PostDetailResponseDto createNewPost(@RequestBody PostCreateRequestDto postDto) {
    return postService.createPost(postDto);
  }

  @PatchMapping("/posts/{postId}")
  public PostDetailResponseDto updateBodyPost(@PathVariable int postId,
                           @RequestBody PostUpdateRequestDto postDto) {
    return postService.updatePost(postDto);
  }

  @PutMapping("/posts/{postId}")
  public int updateLikesPost(@PathVariable int postId){
    return postService.updateLikesPost(postId);
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable int postId) {
    postService.deletePost(postId);
    return postId + "번째 게시판 글이 삭제되었습니다.";
  }

  @GetMapping("/posts/{postId}")
  public PostDetailResponseDto viewPostDetail(@PathVariable int postId) {
    return postService.selectPost(postId);
  }

}
