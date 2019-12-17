package pr01.servlet;

import pr01.dao.ProductDao;
import pr01.entity.Product;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PickProductServlet extends HttpServlet {

  @EJB
  private ProductDao productDao;
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding(response.getCharacterEncoding());
    ServletContext ctx = getServletConfig().getServletContext();
    HttpSession session = request.getSession(true);
    
    try {
      String sProductId = request.getParameter("id");
      int productId = Integer.parseInt(sProductId);
      Product prod = productDao.findById(productId);
      session.setAttribute("product", prod);
      
      ctx.getRequestDispatcher("/product.jsp").forward(request, response);
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  private static final long serialVersionUID = 94589946588337305L;
}
