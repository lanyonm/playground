<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
	<title>Users</title>
</head>
<body>
	<h1>User List:</h1>
	<ul>
		<c:forEach items="${users}" var="user">
			<li>${user.firstName} ${user.lastName} - ${user.email}</li>
		</c:forEach>
	</ul>
	<a href="<%= request.getContextPath() %>">home</a>
</body>
</html>