package org.example.di_springtest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.di_springtest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PostRepository {
  public List<Post> findAll();
  public int insertPost(Post post);
  public Post findById(int postId);
  public void updatePost(Post post);
  public void deletePost(int postId);
}
