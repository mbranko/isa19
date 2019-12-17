<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="user" scope="session" class="pr01.entity.User"/>
<jsp:useBean id="order" scope="session" class="pr01.entity.PurchaseOrder"/>
<html>
  <head>
    <title>Vasa korpa</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <body>
    <h3>Vasa korpa</h3>
    <h4>Korisnik: ${user.firstName} ${user.lastName}</h4>
    <form action="pay" method="post">
	    <table cellspacing="0" cellpadding="2" border="0">
	      <tbody>
	         <tr>
	           <td>Ukupan iznos:</td>
	           <td>${order.total}</td>
	         </tr>
	         <tr>
	           <td>Broj kartice:</td>
	           <td><input type="text" name="cardNumber" size="16"></td>
	         </tr>
	         <tr>
	           <td>Mesec isteka:</td>
	           <td><input type="text" name="expiryMonth" size="2"></td>
	         </tr>
	         <tr>
	           <td>Godina isteka:</td>
	           <td><input type="text" name="expiryYear" size="4"></td>
	         </tr>
	         <tr>
	           <td>Ime na kartici:</td>
	           <td><input type="text" name="cardHolder" size="40"></td>
	         </tr>
           <tr>
             <td>&nbsp;</td>
             <td><input type="submit" value="Plati"></td>
           </tr>
	      </tbody>
	    </table>
    </form>
  </body>
</html>