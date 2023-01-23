package study.spring.helloboot;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1차적으로 class level을 참고하고, 그 다음에 method level을 참고한다
@RequestMapping
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello")
  @ResponseBody
  public String hello(String name) {
    System.out.println("hello");
    return helloService.sayHello(Objects.requireNonNull(name));
  }
}
