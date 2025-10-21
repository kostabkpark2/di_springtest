package org.example.di_springtest.service;

import org.example.di_springtest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository){
    this.postRepository = postRepository;
  }

  public String getAllPost() {
    return postRepository.findAll();
  }
}
