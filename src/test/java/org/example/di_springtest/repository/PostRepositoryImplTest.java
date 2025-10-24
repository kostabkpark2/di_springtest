package org.example.di_springtest.repository;

import org.example.di_springtest.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryImplTest {
  @Autowired
  private PostRepositoryImpl postRepository;

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void findAll() {
    // given
    Post post1 = new Post();
    post1.setTitle("test1");
    post1.setBody("bodytest1");
    postRepository.insertPost(post1);
    // when
    List<Post> all = postRepository.findAll();
    // then
    assertThat(all.size()).isEqualTo(1);
  }

  @Test
  void findById() {
    // given
    Post post1 = new Post();
    post1.setTitle("test1");
    post1.setBody("bodytest1");
//    int postId = postRepository.insertPost(post1);<== 나중에 수정하기
    // when
//    Post findPost = postRepository.findById(postId);
    // then
//    assertThat(findPost.getTitle()).isEqualTo("test1");
  }

  @Test
  void updatePost() {
  }

  @Test
  void deletePost() {
  }
}