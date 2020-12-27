<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<meta charset="ISO-8859-1">
		<title>Facturi</title>
	</head>
	<body>
		<div class="container">
		<button style="margin-top: 10px;" class="btn btn-secondary" onClick="goBack()" type="button">Pagina principala</button>
			<h3>Numele abonatului: ${abonat.getNume() } ${abonat.getPrenume() }</h3>
			<h5>Detaliile contractului</h5>
			
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">NR Contract</th>	
			      <th scope="col">ID Abonat</th>
			      <th scope="col">Cod abonament</th>
			      <th scope="col">Valabilitate</th>
			      <th scope="col">Data incheierii contractului</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th>${contract.getNr_contract()}</th>
			      <th>${contract.getId_abonat()}</th>
			      <th>${contract.getCod_abonament()}</th>
			      <th>${contract.getValabilitate()} zile</th>
			      <th>${contract.getData_incheierii()}</th>
			    </tr>
			  </tbody>
			</table>
			<h5>Facturile abonatului</h5>
			<table class="table table-bordered">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">NR Factura</th>
			      <th scope="col">ID Abonat</th>
			      <th scope="col">Denumire abonament</th>
			      <th scope="col">Data emiterii</th>
			      <th scope="col">Data scadenta</th>
			      <th scope="col">Total plata</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>
					<c:forEach items="${facturi}" var="factura">
						<tr>
							<td>${factura.getNr_factura()}</td>
							<td>${factura.getId_abonat()} </td>
							<td>${factura.getDenumire_abonament()} </td>
							<td>${factura.getData_emitere()}</td>
							<td>${factura.getData_scadenta()}</td>
							<td>${factura.getTotal_plata()} euro</td>
							<td>
								<form action="facturi" method="POST">
									<input type="hidden" name="id_abonat" value="${factura.getId_abonat()}">
									<input type="hidden" name="id_factura" value="${factura.getNr_factura()}">
									<button type="submit" class="btn btn-danger" name="delete_factura">Sterge factura</button>   
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			  
			</table>
			<form method="POST" action="facturi">
				<button class="btn btn-success" type="button" data-toggle="modal" data-target="#adaugareFacturaModalCenter">Adauga o factura</button>
			</form>
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
		<!-- Modal adaugare factura -->
		<div class="modal fade" id="adaugareFacturaModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="adaugareFacturaModalLongTitle">Adaugati o factura</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       	<form method="POST" action="facturi">
		       		<input style="margin-bottom: 10px;" class="form-control" type="date" placeholder="Data emitere factura" onfocus="(this.type='date')" name="data_emitere" required>
		       		<button type="button" class="btn btn-secondary" data-dismiss="modal">Anulare</button>
		        	<button type="submit" class="btn btn-primary" name="adaugare_factura">Adaugare factura</button>
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
</html>