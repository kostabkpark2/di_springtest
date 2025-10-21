package org.example.di_springtest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostAllResponseDto {
  private int postId;
  private String title;
  private int likes;
}
