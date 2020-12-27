<%@ page import="java.util.ArrayList"%>
<%@	page import="daw.bean.Abonament" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<title>Abonamente</title>
	</head>
	<body>
	<div class="container">
		<button style="margin-top:10px;" type="submit" onClick="goBack()" class="btn btn-secondary">Pagina principala</button>
		<h2>Lista cu abonamentele disponibile.</h2>
		<nav>
		
		</nav>
		<div class="contianer-abonamente">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>COD_ABONAMENT</th>
						<th>Denumire</th>
						<th>Tip</th>
						<th>Trafic</th>
						<th>Pret</th>
						<th>Pret extra trafic</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${abonamente}" var="abonament" varStatus="loop">
						<tr>
							<td>${abonament.getCod_abonament()}</td>
							<td>${abonament.getDenumire()} </td>
							<td>${abonament.getTip()}</td>
							<td>${abonament.getTrafic()} GB</td>
							<td>${abonament.getPret()} euro</td>
							<td>${abonament.getPret_extra_benefici()} euro</td>
							<td>
								<form action="abonamente" method="POST">
									<input type="hidden" name="id_abonament" value="${abonament.getCod_abonament()}">
									<button type="submit" class="btn btn-danger" name="delete_abonament">Sterge</button> 
									<button type="submit" class="btn btn-secondary" name="editare_abonament">Editare</button> 
								</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" data-toggle="modal" data-target="#addAbonament" class="btn btn-success">Adauga abonament</button>
			<ul class="pagination d-flex justify-content-center">
					    <c:if test="${prev_page eq '0' }">
					    <li class="page-item">
					      <a class="page-link" href="" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					        <span class="sr-only">Previous</span>
					      </a>
					    </li>
					   </c:if>
					   <c:if test="${prev_page ne '0' }">
					    <li class="page-item">
					      <a class="page-link" href="?page=${prev_page }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					        <span class="sr-only">Previous</span>
					      </a>
					    </li>
					    </c:if>
					    <li class="page-item"><a class="page-link disable-links">${curent_page}</a></li>
					    <c:if test="${next_page eq Total_pages}">
					    <li class="page-item">
					      <a class="page-link" href="" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					        <span class="sr-only">Next</span>
					      </a>
					    </li>
					    </c:if>
					    <c:if test="${next_page ne Total_pages}">
					    <li class="page-item">
					      <a class="page-link" href="?page=${next_page}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					        <span class="sr-only">Next</span>
					      </a>
					    </li>
					    </c:if>
				  </ul>
		</div>
	</div>
	<!-- MODAL PENTRU ADAUGARE ABONAMENT -->
	<div class="modal fade" id="addAbonament" tabindex="-1" role="dialog" aria-labelledby="addAbonament" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="addAbonamentModalLongTitle">Formular adaugare abonament</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <form class="form-group" action="abonamente" method="POST">
	        	<input class="form-control" type="number" placeholder="Cod abonament" name="cod_abonament_field" required>
	        	<input class="form-control" type="text" placeholder="Denumire abonament" name="denumire_field" required>
	        	<input class="form-control" type="text" placeholder="Tip abonament" name="tip_field" required>
	        	<input class="form-control" type="number" step="0.01" placeholder="Trafic de date disponibil in abonament" name="tarfic_field" required>
	        	<input class="form-control" type="number" step="0.01" placeholder="Pret abonament" name="pret_field" required>
	        	<input class="form-control" type="number" step="0.01" placeholder="Pret extra beneficii abonament" name="extra_field" required>
	        	
	        	<input type="submit" class="btn btn-primary" name="adauga_abonament" value="Adauga">
	        	<button type="button" class="btn btn-secondary" data-dismiss="modal">Anuleaza</button>
	        </form>
	      </div>
	    </div>
	  </div>
	  
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
		.form-control{
		margin-top: 5px;
		}
	</style>
</html>
