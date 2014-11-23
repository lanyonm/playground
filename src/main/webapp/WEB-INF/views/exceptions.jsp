<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Exceptions</title>
</head>
<body>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">
		<h2>Exceptions State:</h2>
		<p>
			<span class="label label-<c:choose><c:when test="${exceptionsState}">success</c:when><c:otherwise>default</c:otherwise></c:choose>">${exceptionsState}</span>
		</p>
		<div>
			<form method="POST" class="navbar-form navbar-left">
				<button type="submit" class="btn btn-default">Toggle Exceptions</button>
			</form>
		</div>
	</div>
</body>
</html>