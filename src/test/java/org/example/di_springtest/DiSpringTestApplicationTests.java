package org.example.di_springtest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiSpringTestApplicationTests {
  @BeforeAll
  static void initAll() {
    System.out.println("Before All - initAll");
  }

  @BeforeEach
  void init(){
    System.out.println("Before Each - init");
  }


  @Test
  void testMethodA() {
    System.out.println("TestA!!");
  }

  @Test
  void testMethodB() {
    System.out.println("TestB!!");
  }

  @AfterEach
  void tearDown(){
    System.out.println("After Each - tearDown");
  }

  @AfterAll
  static void tearDownAll() {
    System.out.println("After All - tearDownAll");
  }
}
