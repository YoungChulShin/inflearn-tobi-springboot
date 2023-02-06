package study.spring.config.autoconfig;

import study.spring.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "data")
public class MyDataSourceProperties {

  private String driverClassName;
  private String url;
  private String username;
  private String password;

  public String getDriverClassName() {
    return driverClassName;
  }

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
