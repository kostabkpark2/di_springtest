package org.example.di_springtest.service;

import org.example.di_springtest.model.Post;
import org.example.di_springtest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository){
    this.postRepository = postRepository;
  }

  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  public int createPost(Post post) {
    return postRepository.insertPost(post);
  }

  public Post selectPost(int postId) {
    return postRepository.findById(postId);
  }

  public void updatePost(Post post) {
    Post findPost = postRepository.findById(post.getPostId());
    findPost.setBody(post.getBody());
    postRepository.updatePost(findPost);
  }

  public void deletePost(int postId) {
    postRepository.deletePost(postId);
  }
}
