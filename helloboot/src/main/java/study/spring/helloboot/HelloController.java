package study.spring.helloboot;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 1차적으로 class level을 참고하고, 그 다음에 method level을 참고한다
@RestController
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello")
  public String hello(String name) {
    if (name == null || name.trim().length() == 0) {
      throw new IllegalArgumentException();
    }
    return helloService.sayHello(name);
  }
}
