<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="category" scope="session" class="pr01.entity.Category"/>
<html>
  <head>
    <title>Kategorija: ${category.name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
  <body>
    <h3>Kategorija: ${category.name}</h3>
    <h4>Roditeljska kategorija: <a href="cat?id=${category.parent.id}">${category.parent.name}</a></h4>
    <h4>Potkategorije:</h4>
    <table cellspacing="0" cellpadding="0" border="0">
      <tbody>
        <c:forEach var="cat" items="${category.children}">
          <tr><td><a href="cat?id=${cat.id}">${cat.name}</a></td></tr>
        </c:forEach>
      </tbody>
    </table>
    <h4>Proizvodi:</h4>
    <table cellspacing="0" cellpadding="0" border="0">
      <tbody>
        <c:forEach var="prod" items="${category.products}">
          <tr><td><a href="prod?id=${prod.id}">${prod.name}</a></td></tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>