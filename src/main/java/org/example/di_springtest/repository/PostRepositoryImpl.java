package org.example.di_springtest.repository;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.dto.PostRequiryDto;
import org.example.di_springtest.model.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
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
  public void insertPost(Post post) {
    //System.out.println(post);
    // post.postId 가 전부 0 이 나온 이유 확인 및 수정
    post.setPostId(++sequence);
    posts.put(sequence, post);
    //System.out.println(post);
//    return sequence;  <== 나중에 확인하기
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

  @Override
  public List<Post> findAllDynamic(PostRequiryDto postRequiry) {
    return List.of();
  }
}
