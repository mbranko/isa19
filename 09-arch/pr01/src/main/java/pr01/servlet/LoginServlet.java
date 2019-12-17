package pr01.servlet;

import pr01.dao.CategoryDao;
import pr01.dao.UserDao;
import pr01.entity.Category;
import pr01.entity.User;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("unchecked")
public class LoginServlet extends HttpServlet {

  @EJB
  private UserDao userDao;
  
  @EJB
  private CategoryDao categoryDao;
  
  private String failurePage;
  private String successPage;
  private ServletContext ctx;
  
  @Override
  public void init(ServletConfig cfg) throws ServletException {
    failurePage = cfg.getInitParameter("failure-page");
    if (failurePage == null)
      throw new ServletException(
          "LoginServlet: missing init parameter 'failure-page'");
    successPage = cfg.getInitParameter("success-page");
    if (successPage == null)
      throw new ServletException(
          "LoginServlet: missing init parameter 'success-page'");
    ctx = cfg.getServletContext();
  }
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username == null || password == null)
      throw new ServletException(
          "[LoginServlet] Illegal invocation: no username and/or password");

    User user = userDao.login(username, password);
    if (user == null) {
      ctx.getRequestDispatcher(failurePage).forward(request, response);
      return;
    }
    
    HttpSession session = request.getSession(true);
    session.setAttribute("user", user);
    
    List<Category> roots = (List<Category>)ctx.getAttribute("roots");
    if (roots == null) {
      roots = categoryDao.findRoots();
      ctx.setAttribute("roots", roots);
    }
    
    ctx.getRequestDispatcher(successPage).forward(request, response);
  }
  
  private static final long serialVersionUID = -678832957377757118L;
}
