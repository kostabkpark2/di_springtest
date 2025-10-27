package org.example.di_springtest.service;

import lombok.RequiredArgsConstructor;
import org.example.di_springtest.model.User;
import org.example.di_springtest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByUserId(String userId) {
    return userRepository.findById(userId);
  }

  public void createNewUser(User user) {
    userRepository.insertUser(user);
  }

  public boolean updatePassword(User user, String chagePwd) {
    User findUser = getUserByUserId(user.getUserId());
    if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
      findUser.setPassword(chagePwd);
      userRepository.updateUser(findUser);
      return true;
    }
    return false;
  }

  public void removeUser(String userId) {
    userRepository.deleteUser(userId);
  }
}
