package pr04.beans;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class PrototypeBean {

  private String message;

  public String getMessage() {
    return message;
  }

  @PostConstruct
  public void init() {
    System.out.println("PrototypeBean: @PostConstruct");
    RandomStringGenerator generator =
        new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
    message = generator.generate(16);
  }

  /*
   * Spring nikad nece pozvati @PreDestroy za prototype scope
   * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-factory-scopes-prototype
   */
  @PreDestroy
  public void shutdown() throws Exception {
    System.out.println("PrototypeBean: @PreDestroy");
  }
}
