<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<title>Employer</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="client">Client</a></li>
					<li class="active"><a href="employer">Employer<span class="sr-only">(current)</span></a></li>
					<li><a href="operation">Operation</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="panel panel-default">
		<table class="table">
			<tr>
<!-- Ajouter un client -->
				<td>
					<form action="insererClient" method="post">
						<table class="table">
							<th>Ajouter un client :</th>
							<tr>
								<td>Nom client:</td>
								<td><input type="text" name="nomClient"></td>
							</tr>
							<tr>
								<td>Prénom client:</td>
								<td><input type="text" name="prenomClient"></td>
							</tr>
							<tr>
								<td>Date de naissance:</td>
								<td><input type="text" name="dateNaissance"
									value="yyyy-MM-dd"></td>
							</tr>
							<tr>
								<td>Adresse:</td>
								<td><input type="text" name="adresse"></td>
							</tr>
							<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
						</table>
					</form>

				</td>
<!-- Ajouter un compte courant -->
				<td>
					<form action="insererCompteCourant" method="post">
						<table class="table">
							<th>Ajouter un Compte Courant :</th>
							<tr>
								<td>Solde:</td>
								<td><input type="text" name="solde"></td>
							</tr>
							<tr>
								<td>Decouvert autorisé:</td>
								<td><input type="text" name="decouvert"></td>
							</tr>
							<tr>
								<td>Client:</td>
								<td><select class="selectpicker">
										<c:forEach items="${client}" var="cl">
											<option>${cl.nomClient}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Employe:</td>
								<td><select class="selectpicker">
										<c:forEach items="${employer}" var="em">
											<option>${em.nomEmployer}</option>
										</c:forEach>
								</select></td>
							</tr>
							<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
						</table>
					</form>

				</td>
<!-- Ajouter un compte epargne -->
				<td>
					<form action="insererCompteEpargne" method="post">
						<table class="table">
							<th>Ajouter un Compte Epargne :</th>
							<tr>
								<td>Solde:</td>
								<td><input type="text" name="solde"></td>
							</tr>
							<tr>
								<td>Taux interet:</td>
								<td><input type="text" name="tauxInt"></td>
							</tr>
							<tr>
								<td>Client:</td>
								<td><select class="selectpicker">
										<c:forEach items="${client}" var="cl">
											<option>${cl.nomClient}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Employe:</td>
								<td><select class="selectpicker">
										<c:forEach items="${employer}" var="em">
											<option>${em.nomEmployer}</option>
										</c:forEach>
								</select></td>
							</tr>
							<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
						</table>
					</form>

				</td>
			</tr>
		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des comptes</h3>
		</div>

		<table class="table table-striped">
			<tr class="info">
				<td><b>Id Compte</b></td>
				<td><b>Solde</b></td>
				<td><b>Date de création</b></td>
				<td><b>Client</b></td>
				<td><b>Employe créateur</b></td>
			</tr>
			<c:forEach items="${compte}" var="co">
				<tr>
					<td>${co.idCompte}</td>
					<td>${co.solde}</td>
					<td>${co.dateCreation}</td>
					<td>${co.client.nomClient}</td>
					<td>${co.employer.nomEmployer}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des employes</h3>
		</div>
		<table class="table table-striped">
			<tr class="danger">
				<td><b>Id Employe</b></td>
				<td><b>Nom Employe</b></td>
				<td><b>Comptes crées</b></td>
			</tr>
			<c:forEach items="${employer}" var="em">
				<tr>
					<td>${em.idEmployer}</td>
					<td>${em.nomEmployer}</td>
					<td>
				  <%-- <form action="afficherCompteCreEmp" method="post">
					<select class="selectpicker">
						<option>Compte</option>
						<c:forEach items="${comcre}" var="cc">
							<option>${cc.idCompte}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-success">Charger</button>
					</form> --%>
					
					<select class="selectpicker">
						<option>Compte</option>
						<c:forEach items="${comcre}" var="cc">
							<option>${cc.idEmployer}</option>
						</c:forEach>
					</select>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des groupes</h3>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Id Groupe</b></td>
				<td><b>Nom du groupe</b></td>
				<td><b>Employes</b></td>
			</tr>
			<c:forEach items="${groupe}" var="gr">
				<tr>
					<td>${gr.idGroupe}</td>
					<td>${gr.nomGroupe}</td>
					<td>
					<form action="afficherEmpParGro" method="post">
					<select class="selectpicker">
						<option>Employe</option>
						<c:forEach items="${empgro}" var="eg">
							<option>${eg.idEmploye}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-success">Charger</button>
					</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<table class="table">
			<tr>
				<td><form action="ajouterEmployer" method="post">
						<table class="table">
							<th>Ajouter un employe :</th>
							<tr>
								<td>Nom de l'employe</td>
								<td><input type="text" name="nomEmployer"></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
							</tr>
						</table>
					</form></td>
				<td><form action="ajouterGroupe" method="post">
						<table class="table">
							<th>Ajouter un groupe :</th>
							<tr>
								<td>Nom du groupe</td>
								<td><input type="text" name="nomGroupe"></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
							</tr>
						</table>
					</form></td>
				<td><form action="ajouterEmplGro" method="post">
						<table class="table">
							<th>Ajouter un employe à un groupe :</th>
							<tr>
								<td>Employe</td>
								<td><select class="selectpicker" name="idEmployer">
										<c:forEach items="${employer}" var="em">
											<option value="${em.idEmployer}">${em.nomEmployer}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Groupe</td>
								<td><select class="selectpicker" name="idGroupe">
										<c:forEach items="${groupe}" var="gr">
											<option value="${gr.idGroupe}">${gr.nomGroupe}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-primary">Ajouter</button></td>
							</tr>
						</table>
						<td>
					</form></td>
			</tr>
		</table>
	</div>
</body>
</html>