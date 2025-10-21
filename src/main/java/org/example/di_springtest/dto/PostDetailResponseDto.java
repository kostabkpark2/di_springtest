package org.example.di_springtest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDetailResponseDto {
  private int postId;
  private String title;
  private String body;
  private int likes;
}
