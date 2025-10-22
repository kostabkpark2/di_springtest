package org.example.di_springtest.dto;

import lombok.*;
import org.example.di_springtest.model.Post;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostAllResponseDto {
  private int postId;
  private String title;
  private int likes;

  public static PostAllResponseDto of(Post post) {
    return new PostAllResponseDto(
        post.getPostId(),
        post.getTitle(),
        post.getLikes()
    );
  }
}
