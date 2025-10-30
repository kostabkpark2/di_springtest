package org.example.di_springtest.model;

import lombok.*;
import org.apache.ibatis.type.Alias;

//@Alias("Post") // mybatis 에서 특정 객체만 type-alias-package 적용받게 하기 위해 설정
@NoArgsConstructor
@AllArgsConstructor
@Data // getter,setter,toString, RequiredArgsContructor
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
  private User user;
}
