<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
					<li class="active"><a href="client">Client<span
							class="sr-only">(current)</span></a></li>
					<li><a href="employer">Employer</a></li>
					<li><a href="operation">Operation</a></li>
				</ul>
				<form action="clientMC" method="post"
					class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							name="mc">
					</div>
					<button type="submit" class="btn btn-default">Chercher</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title">
				<b>Liste des clients</b>
			</h2>
		</div>
		<table class="table">
			<thead>
				<tr class="info">
					<th>Id</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Date de naissance</th>
					<th>Adresse</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cli}" var="cl">
					<tr class="active">
						<td>${cl.idClient}</td>
						<td>${cl.nomClient}</td>
						<td>${cl.prenomCLient}</td>
						<td>${cl.dateNaissance}</td>
						<td>${cl.adresse}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title">
				<b>Liste des comptes</b>
			</h2>
			<form action="afficherCompteClient" method="post">
				<select class="selectpicker" name="idClient">
					<option>Nom du Client</option>
					<c:forEach items="${cli}" var="cl">
						<option value="${cl.idClient}">${cl.idClient}</option>
					</c:forEach>
				</select>
				<button type="submit" class="btn btn-success">Charger</button>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr class="info">
					<td><b>Id Compte</b></td>
					<td><b>Solde</b></td>
					<td><b>Date de création</b></td>
					<td><b>Client</b></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${com}" var="co">
					<tr class="active">
						<td>${co.idCompte}</td>
						<td>${co.solde}</td>
						<td>${co.dateCreation}</td>
						<td>${co.client.nomClient}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>