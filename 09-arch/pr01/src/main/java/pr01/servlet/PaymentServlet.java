package pr01.servlet;

import pr01.dao.UserDao;
import pr01.entity.CreditCard;
import pr01.entity.PurchaseOrder;
import pr01.entity.User;
import pr01.session.PurchaseLocal;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentServlet extends HttpServlet {

  @EJB
  PurchaseLocal purchase;
  
  @EJB
  UserDao userDao;
  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/html; charset=utf-8");
    request.setCharacterEncoding(response.getCharacterEncoding());
    ServletContext ctx = getServletConfig().getServletContext();
    HttpSession session = request.getSession(true);
    
    try {
      String cardNumber = request.getParameter("cardNumber");
      String cardHolder = request.getParameter("cardHolder");
      int expiryYear = Integer.parseInt(request.getParameter("expiryYear"));
      int expiryMonth = Integer.parseInt(request.getParameter("expiryMonth"));
      CreditCard card = new CreditCard(expiryMonth, expiryYear, cardHolder, 
          cardNumber);
      PurchaseOrder order = (PurchaseOrder)session.getAttribute("order"); 
      User user = (User)session.getAttribute("user"); 
      boolean status = purchase.processOrder(order, card);
      if (status) {
        userDao.add(user, order);
        session.setAttribute("order", null);
      }
      session.setAttribute("paymentStatus", status ? "OK" : "ERROR");
    
      ctx.getRequestDispatcher("/paymentStatus.jsp").forward(request, response);
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  private static final long serialVersionUID = -7133778514614892121L;
}
