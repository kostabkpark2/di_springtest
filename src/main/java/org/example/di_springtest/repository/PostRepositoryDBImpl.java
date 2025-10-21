package org.example.di_springtest.repository;

import org.example.di_springtest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;


public class PostRepositoryDBImpl implements PostRepository {
  private final String msg ;

  public PostRepositoryDBImpl() {
    this.msg = "hello world - from DBimpl";
  }

  @Override
  public List<Post> findAll() {
    return null;
  }

  @Override
  public int insertPost(Post post) {
    return 0;
  }

  @Override
  public Post findById(int postId) {
    return null;
  }

  @Override
  public void updatePost(Post post) {

  }

  @Override
  public void deletePost(int postId) {

  }
}
