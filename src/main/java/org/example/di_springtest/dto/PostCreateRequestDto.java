package org.example.di_springtest.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequestDto {
  private String title;
  private String body;
}
