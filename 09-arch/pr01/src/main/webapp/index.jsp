<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="user" scope="session" class="pr01.entity.User"/>
<html>
  <head>
    <title>WebShop</title>
  </head>
  <body>
    <h1>WebShop</h1>
    <p>Kategorije proizvoda:</p>
    <table cellspacing="0" cellpadding="0" border="0">
      <tbody>
        <c:forEach var="category" items="${roots}">
          <tr><td><a href="cat?id=${category.id}">${category.name}</a></td></tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>