package org.example.di_springtest.repository;

import org.example.di_springtest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository {
  public List<Post> findAll();
  public int insertPost(Post post);
  public Post findById(int postId);
  public void updatePost(Post post);
  public void deletePost(int postId);
}
