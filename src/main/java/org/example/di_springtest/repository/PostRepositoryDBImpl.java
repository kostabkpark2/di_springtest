package org.example.di_springtest.repository;

import org.springframework.stereotype.Repository;


public class PostRepositoryDBImpl implements PostRepository {
  private final String msg ;

  public PostRepositoryDBImpl() {
    this.msg = "hello world - from DBimpl";
  }

  @Override
  public String findAll() {
    return msg;
  }
}
