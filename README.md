# 저장소 설명
인프런 `토비의 스프링 부트` 강으 실습 저장소

# 메모
## 스프링 웹요청 처리
스프링을 이용해서 기능을 개발하면 보통 요청을 받은 시점부터 응답객체를 만들기 까지의 코드를 구현하게 된다. 그런데 실제로 우리가 개발하는 코드가 동작하기 위해서는 앞단에서 사용자의 요청을 받아서 우리가 개발하는 컨트롤러를 호출해주는 등의 작업이 발생한다. 
```
Client Request ---> Servlet Container --> Spring Container
```

Servlet Container와 여기에 등록된 Servlet이 그 역할을 해주고 있다. 즉, Servlet이 사용자의 요청을 받아서 우리가 개발하는 빈을 호출하고 있다. Servlet Container는 대표적으로 Tomcat이 있고, 그 외에 Jetty, Undertow 등도 있다.

하지만 우리가 코드를 개발할 때에는 톰캣, 서블릿 등의 개발은 해주고 있지 않은데, 이는 스프링부트가 내부적으로 처리를 해주고 있기 때문이다. 스프링부트를 시작하면 자동으로 톰캣 서버가 뜨는 이유이기도 하다. 

하지만 모든 요청에 대해서 서블릿을 만들기 보다는 하나의 서블릿을 통해서 클라이언트의 요청을 받고, 이 서블릿이 적절한 핸들러를 호출해주는 방법을 많이 사용하고 있다. 이러한 방법을 `프론트컨트롤러 패턴` 이라고 한다. 이 방법을 이용하면 공통되는 코드를 프론트컨트롤러에서 하나의 코드로 처리할 수 있기 때문에 중복을 줄일 수 있다. 공통 코드로는 인증,보안, 다국어, 그 외 공통 기능 처리 등이 있다. 

프론트 컨트롤러는 `매핑`, `바인딩` 방법을 이용해서 핸들러를 호출한다. 
- 매핑: url, method 등의 값을 확인해서 요청을 구분하는 개념
- 바인딩: 웹 요청으로 전달 받은 값을, 핸들러에서 필요한 값으로 변환하는 방법. 예: String, Dto class 등올 변환

## Bean
POJO와 configuration metadata를 이용해서 SpringContainer는 객체를 생성할 수 있다. ApplicationContext가 SpringConainer이다. 즉, ApplicationContext를 통해서 빈을 등록할 수 있고, 가져올 수 있다. 

Bean을 등록하는 방법
1. RegisterBean 메서드를 통해서 등록
2. FactoryMethod를 통해서 빈을 정의하고 등록하는 방법
   ```java
   @Configuration
   class Test {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
   }
   ```
3. CompoentScan을 통해서 등록하는 방법
   - `@Component` 애노테이션이 정의된 클래스를 찾아서 빈으로 등록한다

## DispatcherServlet
Servlet 중에 하나. 애노테이션을 통해서 매핑 정보를 설정해줄 수 있다

방법
- class level에 `@RequestMapping`을 선언하고, MethodLevel에 `@GetMapping, @PostMapping`등을 선언한다
- `@Controller, @RestController` 애노테이션이 있으면, `@RequemstMapping`이 없어도 된다