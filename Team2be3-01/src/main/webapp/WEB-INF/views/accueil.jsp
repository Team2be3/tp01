<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/accueil.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Client</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="accueil">Accueil<span
							class="sr-only">(current)</span></a></li>
					<li><a href="client">Client</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Sign in</h1>
				<div class="account-wall">
					${message}
					<form class="form-signin" action="login" method="post">
						<input type="text" class="form-control" name="id" placeholder="idEmployé" required autofocus>
							 <input type="password" class="form-control" name="nom" placeholder="nomEmployé" required>					
						<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
							
					</form>
				</div>
				
			</div>
		</div>
	</div>
  

</html>