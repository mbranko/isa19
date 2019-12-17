package pr01.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pr01.dao.UserDao;
import pr01.entity.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {
  
  @EJB
  UserDao userDao;
  
  /* u realnom sistemu koristili bismo OAuth protokol */
  @GET
  @Path("/login")
  public User login(@QueryParam("username") String username, @QueryParam("password") String password) {
    System.out.println("Trying: " + username + ":" + password);
    User user = userDao.login(username, password);
    System.out.println(user);
    return user;
  }
}
