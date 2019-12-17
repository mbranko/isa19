package pr01.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pr01.dao.ProductDao;
import pr01.dao.PurchaseOrderDao;
import pr01.dao.UserDao;
import pr01.entity.OrderItem;
import pr01.entity.Product;
import pr01.entity.PurchaseOrder;
import pr01.entity.User;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdersResource {

  @EJB
  private UserDao userDao;
  
  @EJB
  private PurchaseOrderDao orderDao;
  
  @EJB
  private ProductDao productDao;
  
  @GET
  @Path("/{id}")
  public PurchaseOrder getOrder(@PathParam("id") int orderId) {
    PurchaseOrder order = orderDao.findById(orderId);
    return order;
  }
  
  @POST
  public PurchaseOrder addOrder(PurchaseOrder order) {
    // procitaj userId iz zahteva
    int userId = order.getUser().getId();
    // otkaci lazni user objekat 
    order.setUser(null);
    // ucitaj usera iz baze
    User user = userDao.findById(userId);
    if (user == null)
      return null;
    // za svaki orderitem u orderu zakaci product
    // koji smo ucitali iz baze
    for (OrderItem item: order.getItems()) {
      int prodId = item.getProduct().getId();
      Product p = productDao.findById(prodId);
      item.setProduct(p);
    }
    // snimi order i vezi ga za usera
    order = userDao.add(user, order);
    return order;
  }
}
