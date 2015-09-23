<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit article</title>
</head>
<body>
  <form:form action="/articles" method="put">
      <%@ include file="form.jsp"%>
  </form:form>
</body>
</html>
