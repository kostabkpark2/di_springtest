package org.example.di_springtest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.di_springtest.dto.PostRequiryDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.model.User;
import org.example.di_springtest.repository.PostRepository;
import org.example.di_springtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  public List<Post> getAllPost() {
    return postRepository.findAll();
  }

  public int createPost(Post post) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User findUser = userRepository.findById(user.getUserId());
    log.info("로그인한 사용자 id : {}", findUser.getUserId());
    if(findUser == null) {
      return 0;       // < == 나중에 수정할 것
    }
    post.setUser(findUser);
    log.info("게시판 글 등록한 사용자 id : {}", post.getUser().getUserId());
    postRepository.insertPost(post);
    return post.getPostId();
  }

  public Post selectPost(int postId) {
    return postRepository.findById(postId);
  }

  public void updatePost(Post post) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User findUser = userRepository.findById(user.getUserId());
    Post findPost = postRepository.findById(post.getPostId());
    //  본인이 작성한 post 만 수정할 수 있음
    if(findUser != null && findUser.getUserId().equals(findPost.getUser().getUserId())) {
      findPost.setBody(post.getBody());
      postRepository.updatePost(findPost);
    }
  }

  public void deletePost(int postId) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User findUser = userRepository.findById(user.getUserId());
    Post findPost = postRepository.findById(postId);
    //  본인이 작성한 post 만 삭제할 수 있음
    if(findUser != null && findPost != null &&
        findUser.getUserId().equals(findPost.getUser().getUserId())) {
      postRepository.deletePost(postId);
    }
  }

  public List<Post> selectAllPostsDynamicCondition(PostRequiryDto postRequiry) {
    return postRepository.findAllDynamic(postRequiry);
  }
}
