<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><dec:title default="playground" /></title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">

		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<%= request.getContextPath() %>">Playground</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<%= request.getContextPath() %>/users">Users</a></li>
						<li<%= request.getRequestURI().contains("exceptions") ? " class=\"active\"" : "" %>><a href="<%= request.getContextPath() %>/exceptions">Exceptions</a></li>
<!-- 						<li class="active"><a href="#">Link</a></li> -->
<!-- 						<li class="dropdown"> -->
<!-- 							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a> -->
<!-- 							<ul class="dropdown-menu"> -->
<!-- 								<li><a href="#">Action</a></li> -->
<!-- 								<li><a href="#">Another action</a></li> -->
<!-- 								<li><a href="#">Something else here</a></li> -->
<!-- 								<li class="divider"></li> -->
<!-- 								<li class="dropdown-header">Nav header</li> -->
<!-- 								<li><a href="#">Separated link</a></li> -->
<!-- 								<li><a href="#">One more separated link</a></li> -->
<!-- 							</ul> -->
<!-- 						</li> -->
					</ul>
<!-- 					<ul class="nav navbar-nav navbar-right"> -->
<!-- 						<li class="active"><a href="./">Default</a></li> -->
<!-- 						<li><a href="../navbar-static-top/">Static top</a></li> -->
<!-- 						<li><a href="../navbar-fixed-top/">Fixed top</a></li> -->
<!-- 					</ul> -->
				</div><!--/.nav-collapse -->
			</div><!--/.container-fluid -->
		</div>

		<!-- layout content -->
		<dec:body />
		
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>