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
<body class="containeracceuil">
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
				<h1 class="text-center login-title">Login</h1>
				<div class="account-wall">
					<h1><div class="erreur">
					${message} 
					
					<c:set var="mess" value="${messageb}" scope="page" />
					<c:if test="${mess==3}">
					<img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                    </c:if>
                    </div>
					</h1>
					<form class="form-signin" action="loginb" method="post">
						<input type="text" class="form-control" name="id" placeholder="idEmployé" required autofocus>
							 <input type="password" class="form-control" name="nom" placeholder="nomEmployé" required>					
						<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
							
					</form>
				</div>
				
			</div>
		</div>
	</div>
  

</html>