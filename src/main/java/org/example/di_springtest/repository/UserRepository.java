package org.example.di_springtest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.di_springtest.dto.PostRequiryDto;
import org.example.di_springtest.model.Post;
import org.example.di_springtest.model.User;

import java.util.List;

@Mapper
public interface UserRepository {
  public List<User> findAll();
  public void insertUser(User user);
  public User findById(String userId);
  public void updateUser(User user);
  public void deleteUser(String userId);
}
