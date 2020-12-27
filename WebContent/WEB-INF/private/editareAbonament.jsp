<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h2>Editare abonament</h2>
			<form class="form-group" action="editabonament" method="POST">
	        	<input class="form-control" type="hidden" placeholder="Cod abonament" name="cod_abonament_field" value="${abonament.getCod_abonament()}">
	        	<input class="form-control" type="text" placeholder="Denumire abonament" name="denumire_field" value="${abonament.getDenumire()}">
	        	<input class="form-control" type="text" placeholder="Tip abonament" name="tip_field" value="${abonament.getTip()}">
	        	<input class="form-control" type="number" step="0.01" placeholder="Trafic de date disponibil in abonament" name="tarfic_field" value="${abonament.getTrafic()}">
	        	<input class="form-control" type="number" step="0.01" placeholder="Pret abonament" name="pret_field" value="${abonament.getPret()}">
	        	<input class="form-control" type="number" step="0.01" placeholder="Pret extra beneficii abonament" name="extra_field" value="${abonament.getPret_extra_benefici()}">
	        	
	        	<input type="submit" class="btn btn-primary" name="editare_abonament" value="Salveaza editarea">
	        	<input type="submit" class="btn btn-secondary" name="goToSubscriptions" value="Anuleaza">
	        </form>
		</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>