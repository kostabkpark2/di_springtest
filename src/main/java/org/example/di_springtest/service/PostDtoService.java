package org.example.di_springtest.service;

import org.example.di_springtest.dto.PostAllResponseDto;
import org.example.di_springtest.dto.PostCreateRequestDto;
import org.example.di_springtest.dto.PostDetailResponseDto;
import org.example.di_springtest.dto.PostUpdateRequestDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDtoService {
  private final PostRepository postRepository;

  @Autowired
  public PostDtoService(PostRepository postRepository){
    this.postRepository = postRepository;
  }

  public List<PostAllResponseDto> getAllPost() {
    List<Post> allPosts = postRepository.findAll();
    List<PostAllResponseDto> allPostDtos = allPosts.stream().map(PostAllResponseDto::of).collect(Collectors.toList());
    return allPostDtos;
  }

  public PostDetailResponseDto createPost(PostCreateRequestDto postDto) {
    Post post = new Post();
    post.setTitle(postDto.getTitle());
    post.setBody(postDto.getBody());
    int postId = postRepository.insertPost(post);
    Post newPost = postRepository.findById(postId);
    PostDetailResponseDto postDtoRet = PostDetailResponseDto.of(newPost);
    return postDtoRet;
  }

  public PostDetailResponseDto selectPost(int postId) {
    Post findPost = postRepository.findById(postId);
    PostDetailResponseDto postDto = PostDetailResponseDto.of(findPost);
    return postDto;
  }

  public PostDetailResponseDto updatePost(PostUpdateRequestDto postDto) {
    Post findPost = postRepository.findById(postDto.getPostId());
    findPost.setBody(postDto.getBody());
    postRepository.updatePost(findPost);
    Post updatedPost = postRepository.findById(postDto.getPostId());
    PostDetailResponseDto postDtoRet = PostDetailResponseDto.of(updatedPost);
    return postDtoRet;
  }

  public void deletePost(int postId) {
    postRepository.deletePost(postId);
  }

  public int updateLikesPost(int postId) {
    Post findPost = postRepository.findById(postId);
    int likes = findPost.getLikes();
    findPost.setLikes(++likes);
    System.out.println(findPost);
    postRepository.updatePost(findPost);
    return likes;
  }
}
