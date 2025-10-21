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

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostRestDtoController {
  private final PostDtoService postService;

  @GetMapping("/posts")
  public List<PostAllResponseDto> viewAllPosts() {

    return null;
    //postService.getAllPost();
  }

  @PostMapping("/posts")
  public PostDetailResponseDto createNewPost(@RequestBody PostCreateRequestDto postDto) {
    Post post = new Post();
    post.setTitle(postDto.getTitle());
    post.setBody(postDto.getBody());
    String msg = postService.createPost(post) + "번째 게시판 글이 등록되었습니다.";
    return null;
  }

  @PatchMapping("/posts/{postId}")
  public PostDetailResponseDto updateBodyPost(@PathVariable int postId,
                           @RequestBody PostUpdateRequestDto postDto) {
    Post post = new Post();
    post.setPostId(postId);
    post.setBody(postDto.getBody());
    postService.updatePost(post);
    return null;
        //postId + "번째 게시판 글이 수정되었습니다.";
  }

  @PutMapping("/posts/{postId}")
  public int updateLikesPost(@PathVariable int postId){

    Post post = new Post();
    post.setPostId(postId);
//    post.setBody(postDto.getBody());
    postService.updatePost(post);
    return 0;
    //postId + "번째 게시판 글이 수정되었습니다.";
  }

  @DeleteMapping("/posts/{postId}")
  public String deletePost(@PathVariable int postId) {
    postService.deletePost(postId);
    return postId + "번째 게시판 글이 삭제되었습니다.";
  }

  @GetMapping("/posts/{postId}")
  public PostDetailResponseDto viewPostDetail(@PathVariable int postId) {
    return null;
        //postService.selectPost(postId);
  }

}
