package study.spring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[] {
        "study.spring.config.autoconfig.DispatcherServletConfig",
        "study.spring.config.autoconfig.TomcatWebServerConfig"
    };
  }
}
