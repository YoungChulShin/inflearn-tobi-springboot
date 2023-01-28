package study.spring.helloboot;

import org.springframework.boot.SpringApplication;
import study.spring.config.MySpringBootApplication;

@MySpringBootApplication
public class HellobootApplication {

  public static void main(String[] args) {
    SpringApplication.run(HellobootApplication.class, args);
  }
}
