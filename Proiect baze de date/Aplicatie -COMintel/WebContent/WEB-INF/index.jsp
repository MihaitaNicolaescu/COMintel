<%@ page import="java.util.ArrayList"%>
<%@	page import="daw.bean.Abonat" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
	</head>

	<body>
		<div class="container-fluid">
			<h2>COMintel pagina principala</h2>
			<div class="contianer">
				<nav>
					<form action="index" method="post">
						<button class="btn btn-secondary" type="button" name="abonamente" onclick="goToAbonamente()">Abonamente</button>
						<button class="btn btn-secondary" type="submit" name="logout">Logout</button>
					</form>
				</nav>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID_ABONAT</th>
							<th scope="col">Nume</th>
							<th scope="col">Prenume</th>
							<th scope="col">Adresa</th>
							<th scope="col">Telefon</th>
							<th scope="col">CNP</th>
							<th scope="col">COD_ABONAMENT</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${abonati}" var="abonat" varStatus="loop">
						<tr>
							<td>${abonat.getId_abonat()}</td>
							<td>${abonat.getNume()} </td>
							<td>${abonat.getPrenume()}</td>
							<td>${abonat.getAdresa()}</td>
							<td>${abonat.getTelefon()}</td>
							<td>${abonat.getCnp()}</td>
							<td>${abonat.getCod_abonament()}</td>
							<td>
								<form action="index" method="POST">
									<input type="hidden" name="id_abonat" value="${abonat.getId_abonat()}">
									<button type="submit" class="btn btn-danger" name="delete_abonat">Sterge</button> 
									<button type="submit" class="btn btn-secondary" name="editare_abonat">Editare</button>
									<button type="submit" class="btn btn-secondary" name="facturi_abonat">Vizualizare detalii facturi</button>  
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
				<button class="btn btn-success" data-toggle="modal" type="button" data-target="#adaugareAbonatModal">Adauga abonat</button>
				</div>
			</div>
		<!-- Modal adaugare abonat-->
	<div class="modal fade" id="adaugareAbonatModal" tabindex="-1" role="dialog" aria-labelledby="adaugareAbonatModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="adaugareAbonatModalTitle">Adaugare abonat</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
				<div class="modal-body">
					<form method="POST" action="index">
						<input class="form-control" type="text" placeholder="Nume abonat" name="nume_abonat" >
						<input class="form-control" type="text" placeholder="Prenume abonat" name="prenume_abonat" >
						<input class="form-control" type="text" placeholder="Adresa abonat" name="adresa_abonat" >
						<input class="form-control" type="number" placeholder="Telefon abonat" name="telefon_abonat" >
						<input class="form-control" type="number" placeholder="CNP abonat" name="cnp_abonat" >
						<input class="form-control" type="number" placeholder="Cod abonament detinut" name="cod_abonament_abonat" >
						<input class="form-control" onfocus="(this.type='date')" placeholder="Data incheiere contract" name="data_incheiere" >
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Anuleaza</button>
						<button type="submit" class="btn btn-primary" name="adauga_abonat">Adauga abonat</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>

<script>
	function goToAbonamente(){
		window.location.href = "abonamente";
	}
</script>