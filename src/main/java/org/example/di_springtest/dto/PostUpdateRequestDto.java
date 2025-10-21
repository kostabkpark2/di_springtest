package org.example.di_springtest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequestDto {
  private int postId;
  private String body;
}
