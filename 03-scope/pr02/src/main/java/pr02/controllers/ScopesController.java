package pr02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pr02.beans.*;

import java.util.Map;

@Controller
public class ScopesController {

  @Autowired
  private SingletonBean singletonBean;

  @Autowired
  private PrototypeBean prototypeBean;

  @Autowired
  private RequestBean requestBean;

  @Autowired
  private SessionBean sessionBean;

  @Autowired
  private GlobalSessionBean globalSessionBean;

  @Autowired
  private ApplicationBean applicationBean;

  @RequestMapping("/scopes")
  public String getScopes(Map<String, Object> model) {
    model.put("singletonBean", singletonBean);
    model.put("prototypeBean", prototypeBean);
    model.put("requestBean", requestBean);
    model.put("sessionBean", sessionBean);
    model.put("globalSessionBean", globalSessionBean);
    model.put("applicationBean", applicationBean);
    return "scopes";
  }
}
