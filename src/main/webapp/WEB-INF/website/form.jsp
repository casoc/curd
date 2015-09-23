<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${article.id != null}">
<div class="field">
  <input type="hidden" name="id" value="<c:out value='${article.id}'/>"/>
</div>
</c:if>
<div class="field">
  <label for="title">title:</label>
  <input type="text" name="title" id="title" value="<c:out value='${article.title}'/>"/>
</div>
<div class="field">
  <label for="author">author:</label>
  <input type="text" name="author" id="author" value="<c:out value='${article.author}'/>"/>
</div>
<div class="field">
  <label for="content">content:</label>
  <input type="text" name="content" id="content" value="<c:out value='${article.content}'/>"/>
</div>
<div class="actions">
  <input type="submit" value="submit"/>
</div>
