package study.spring.config.autoconfig;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import study.spring.config.ConditionalMyOnClass;
import study.spring.config.EnableMyConfigurationProperties;
import study.spring.config.MyAutoConfiguration;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
public class DataSourceConfig {
  @Bean
  DataSource dataSource(MyDataSourceProperties properties) {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
    dataSource.

  }
}
