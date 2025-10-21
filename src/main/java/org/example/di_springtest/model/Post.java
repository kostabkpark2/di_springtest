package org.example.di_springtest.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter,setter,toString, RequiredArgsContructor
public class Post {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
