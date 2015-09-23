<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>articles index</title>
  </head>
  <body>
  <table>
    <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
      <th>Content</th>
      <th colspan="2"></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${articles}" var="article">
    <tr>
      <td><c:out value="${article.title}"/></td>
      <td><c:out value="${article.author}"/></td>
      <td><c:out value="${article.content}"/></td>
      <td><a href="/article/<c:out value='${article.id}/edit'/>">Edit</a></td>
      <td><a href="/article/<c:out value='${article.id}/delete'/>">Destroy</a></td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="/articles/new">Create new article</a>
  </body>
</html>