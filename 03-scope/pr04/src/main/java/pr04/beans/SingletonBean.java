package pr04.beans;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class SingletonBean {

  private String message;

  public String getMessage() {
    return message;
  }

  @PostConstruct
  public void init() throws Exception {
    System.out.println("SingletonBean: @PostConstruct");
    RandomStringGenerator generator =
        new RandomStringGenerator.Builder().withinRange('A', 'Z').build();
    message = generator.generate(16);
  }

  @PreDestroy
  public void shutdown() throws Exception {
    System.out.println("SingletonBean: @PreDestroy");
  }
}
