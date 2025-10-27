package org.example.di_springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DiSpringTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(DiSpringTestApplication.class, args);
  }

}
