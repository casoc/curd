<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new article</title>
</head>
<body>
  <form action="/articles" method="post">
      <%@ include file="form.jsp"%>
  </form>
</body>
</html>
