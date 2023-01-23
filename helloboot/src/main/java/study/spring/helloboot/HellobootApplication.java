package study.spring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

  public static void main(String[] args) {
    // Spring Container 생성
    GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
    applicationContext.registerBean(HelloController.class);
    applicationContext.registerBean(SimpleHelloService.class);
    applicationContext.refresh(); // create bean object

    // Servlet Webserver 생성 및 실행
    ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    WebServer webServer = serverFactory.getWebServer(servletContext -> {
      servletContext.addServlet(
              "dispatcherServlet",
              new DispatcherServlet(applicationContext))
          .addMapping("/*");
    });
//    WebServer webServer = serverFactory.getWebServer(servletContext -> {
//      servletContext.addServlet("frontcontroller", new HttpServlet() {
//        @Override
//        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//          // 인증, 보안, 다국어, 공통 기능 처리
//
//          if (req.getRequestURI().equals("/hello") &&
//              req.getMethod().equals(HttpMethod.GET.name())) {  // 매핑
//            String name = req.getParameter("name");
//
//            HelloController helloController = applicationContext.getBean(HelloController.class);
//            String ret = helloController.hello(name); // 바인딩
//
//            resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
//            resp.getWriter().println(ret);
//          } else {
//            resp.setStatus(HttpStatus.NOT_FOUND.value());
//          }
//        }
//      }).addMapping("/*");
//    });
    webServer.start();
  }
}
