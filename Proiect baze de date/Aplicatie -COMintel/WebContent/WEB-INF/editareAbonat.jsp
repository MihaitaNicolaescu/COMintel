<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<meta charset="ISO-8859-1">
		<title>Editare abonat</title>
	</head>
	<body>
		<div style="margin-top: 100px;" class="container d-flex justify-content-center">
			<form class="form-group" action="editabonat" method="POST">
				<h2>Editare abonat</h2>
	        	<input class="form-control" type="hidden" placeholder="Cod abonat" name="id_abonat" value="${abonat.getId_abonat()}" required>
	        	<input class="form-control" type="text" placeholder="Nume abonat" name="nume_abonat" value="${abonat.getNume()}" required>
	        	<input class="form-control" type="text" placeholder="Prenume abonat" name="prenume_abonat" value="${abonat.getPrenume()}" required>
	        	<input class="form-control" type="text" placeholder="Adresa abonat" name="adresa_abonat" value="${abonat.getAdresa()}" required>
	        	<input class="form-control" type="number" placeholder="Telefon abonat" name="telefon_abonat" value="${abonat.getTelefon()}" required>
	        	<input class="form-control" type="number" placeholder="CNP abonat" name="cnp_abonat" value="${abonat.getCnp()}" required>
	        	<input class="form-control" type="number" placeholder="Cod abonament detinut" name="cod_abonament_abonat" value="${abonat.getCod_abonament()}" required>
	        	
	        	<button type="submit" class="btn btn-primary" name="editare_abonat">Salveaza editarea</button>
	        	<button type="button" class="btn btn-danger" onClick="goBack()">Anuleaza</button>
	        </form>
		</div>
		<script>
			function goBack(){
				window.location.href="index";
			}
		</script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
	<style>
		input{
			margin-bottom: 5px;
		}
		.form-control{
			width: 300px;
		}
		.btn{
			width: 100%;
			margin-bottom: 5px;
		}
	</style>
</html>