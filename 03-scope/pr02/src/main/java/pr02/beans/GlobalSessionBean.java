package pr02.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="globalSession", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GlobalSessionBean {

  private int count = 0;

  public int getCount() {
    return ++count;
  }
}
