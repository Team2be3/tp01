<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Employer</title>
</head>
<body>
	<div class="panel-heading">
		<table class="table">
			<tr>
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
							<td><button type="submit" class="btn btn-primary">Enregistrer</button></td>
						</table>
					</form>
				</td>
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
								<td><select class="selectpicker" name="idClient">
										<option value="">test</option>
								</select></td>
							</tr>
							<tr>
								<td>Employer:</td>
								<td><select class="selectpicker" name="idEmployer">
										<option value="">test</option>
								</select></td>
							</tr>
							<td><button type="submit" class="btn btn-primary">Enregistrer</button></td>
						</table>
					</form>
				</td>
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
								<td><select class="selectpicker" name="idClient">
										<option value="">test</option>
								</select></td>
							</tr>
							<tr>
								<td>Employer:</td>
								<td><select class="selectpicker" name="idEmployer">
										<option value="">test</option>
								</select></td>
							</tr>
							<td><button type="submit" class="btn btn-primary">Enregistrer</button></td>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>