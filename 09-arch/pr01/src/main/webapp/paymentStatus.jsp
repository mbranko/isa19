<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="user" scope="session" class="pr01.entity.User"/>
<jsp:useBean id="paymentStatus" scope="session" class="java.lang.String"/>
<html>
  <head>
    <title>Kupovina</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <body>
    <h3>Status placanja</h3>
    <h4>Korisnik: ${user.firstName} ${user.lastName}</h4>
    <h4>Placanje: <%= paymentStatus.equals("OK") ? "uspesno" : "neuspesno" %></h4>
    <form action="index.jsp" method="get">
      Nazad na <input type="submit" value="pocetak">
    </form>
  </body>
</html>