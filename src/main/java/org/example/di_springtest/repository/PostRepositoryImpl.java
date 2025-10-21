package org.example.di_springtest.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository {
  private final String msg ;

  public PostRepositoryImpl() {
    this.msg = "hello world - from impl";
  }

  @Override
  public String findAll() {
    return msg;
  }
}
