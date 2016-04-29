<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Operation</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="accueil">Accueil</a></li>
					<li><a href="client">Client</a></li>
					<li><a href="employer">Employer</a></li>
					<li class="active"><a href="operation">Operation<span
							class="sr-only">(current)</span></a></li>

				</ul>
			</div>
		</div>
	</nav>

	<table class="table">
		<tr>
			<td>
				<form action="operationVirement" method="post">
					<table class="table">
						<th>Virement</th>
						<tr>
							<td>Date de l'operation</td>
							<td><input type="text" name="dateOperation" value="yyyy-MM-dd"></td>
						</tr>
						<tr>
							<td>Choisir le montant</td>
							<td><input type="text" name="montant"></td>
						</tr>
						<tr>
							<td>Choisir le Compte à débiter</td>
							<td><select class="selectpicker" name="idCompte1">
								<option>IdCompte</option>
								<c:forEach items="${compte}" var="cl">
									<option value="${cl.idCompte}">${cl.idCompte}</option>
								</c:forEach>
							</select></td>
						</tr>
						<tr>
						<td>Choisir le Compte à créditer</td>
						<td>
							<select class="selectpicker" name="idCompte2">
								<option>IdCompte</option>
								<c:forEach items="${compte}" var="cl">
								
									<option value="${cl.idCompte}">${cl.idCompte}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
						<td>Choisir l'employé qui effectue l'opération</td>
						<td>
							<select class="selectpicker" name="idEmployer">
								<option>NomEmployé</option>
								<c:forEach items="${employer}" var="empl">
								
									<option value="${empl.idEmployer}">${empl.nomEmployer}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-success">Valider</button></td>
						</tr>
					</table>
				</form>
			</td>

			<td>
				<form action="operationVersement" method="post">
					<table class="table">
						<th>Versement</th>
						<tr>
							<td>Date de l'operation</td>
							<td><input type="text" name="dateOperation" value="yyyy-MM-dd"></td>
						</tr>
						<tr>
							<td>Choisir le montant</td>
							<td><input type="text" name="montant"></td>
						</tr>
						<tr>
							<td>Choisir le Compte à créditer</td>
							<td><select class="selectpicker" name="idCompte">
								<option>IdCompte</option>
								<c:forEach items="${compte}" var="cl">
									<option value="${cl.idCompte}">${cl.idCompte}</option>
								</c:forEach>
							</select></td>
						<tr>
						<tr>
						<td>Choisir l'employé qui effectue l'opération</td>
						<td>
							<select class="selectpicker" name="idEmployer">
								<option>NomEmployé</option>
								<c:forEach items="${employer}" var="empl">
								
									<option value="${empl.idEmployer}">${empl.nomEmployer}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-success">Valider</button></td>
						</tr>
					</table>
				</form>
			</td>

			<td>
				<form action="operationRetrait" method="post">
					<table class="table">
						<th>Retrait</th>
						<tr>
							<td>Date de l'operation</td>
							<td><input type="text" name="dateOperation" value="yyyy-MM-dd"></td>
						</tr>
						<tr>
							<td>Choisir le montant</td>
							<td><input type="text" name="montant"></td>
						</tr>
						<tr>
							<td>Choisir le Compte à débiter</td>
							<td><select class="selectpicker" name="idCompte">
								<option>IdCompte</option>
								<c:forEach items="${compte}" var="cl">
									<option value="${cl.idCompte}">${cl.idCompte}</option>
								</c:forEach>
							</select></td>
						<tr>
						<tr>
						<td>Choisir l'employé qui effectue l'opération</td>
						<td>
							<select class="selectpicker" name="idEmployer">
								<option>NomEmployé</option>
								<c:forEach items="${employer}" var="empl">
								
									<option value="${empl.idEmployer}">${empl.nomEmployer}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-success">Valider</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>



</body>
</html>