<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Todo List</title>
</head>
<body>
  <div class="jumbotron">
    <h1>Todo List</h1>
    <ul>
      <c:forEach items="${todoList}" var="todo">
        <li>${todo.title} - <a class="" href="${todo.id}/edit">edit</a> - <em>created ${todo.dateCreated}</em></li>
      </c:forEach>
    </ul>
    <p><a class="btn btn-default" href="0/edit" role="button">Add Task</a></p>
  </div>
</body>
</html>
