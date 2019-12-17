<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="product" scope="session" class="pr01.entity.Product"/>
<html>
  <head>
    <title>Proizvod: ${product.name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <body>
    <h3>Proizvod: ${product.name}</h3>
    <table cellspacing="0" cellpadding="0" border="0">
      <tbody>
        <tr>
          <td>Roditeljska kategorija:</td>
          <td><a href="cat?id=${product.category.id}">${product.category.name}</a></td>
        </tr>
        <tr>
          <td>Proizvodjac:</td>
          <td>${product.vendor}</td>
        </tr>
        <tr>
          <td>Opis:</td>
          <td>${product.description}</td>
        </tr>
        <tr>
          <td>Cena:</td>
          <td>${product.price}</td>
        </tr>
      </tbody>
    </table>
    <p>
	    <form action="add" method="post">
	      Zelim da kupim <input type="text" name="quantity" size="5"> komada. 
	      <input type="submit" value="Dodaj">
	    </form>
    </p>
  </body>
</html>