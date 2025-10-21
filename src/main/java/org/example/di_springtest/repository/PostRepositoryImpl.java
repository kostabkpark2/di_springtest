package org.example.di_springtest.repository;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepositoryImpl implements PostRepository {
  private final Map<Integer, Post> posts;
  private int sequence ;

  public PostRepositoryImpl() {
    this.posts = new HashMap<>();
    sequence = 0;
  }

  @Override
  public List<Post> findAll() {
    return new ArrayList<>(posts.values());
  }

  @Override
  public int insertPost(Post post) {
    posts.put(++sequence, post);
    return sequence;
  }

  @Override
  public Post findById(int postId) {
    return posts.get(postId);
  }

  @Override
  public void updatePost(Post post) {
    posts.put(post.getPostId(), post);
  }

  @Override
  public void deletePost(int postId) {
    posts.remove(postId);
  }
}
