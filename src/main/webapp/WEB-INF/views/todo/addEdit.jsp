<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Todo ${ todo.id == 0 ? 'Add' : 'Edit' }</title>
</head>
<body>
  <div class="jumbotron">
    <h1>Todo ${ todo.id == 0 ? 'Add' : 'Edit' }</h1>
    <div>
      <form:form commandName="todo">
        <form:label path="title">Title</form:label>
        <form:input path="title" maxlength="250" />
        <input type="submit" value="Save" />
      </form:form>
    </div>
  </div>
</body>
</html>
