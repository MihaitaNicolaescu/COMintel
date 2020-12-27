<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Login page</title>
</head>
<body>
	<div style="width: 400px; margin-top: 300px;" class="container">
		<h2>COMintel login page</h2>
		<form action="login" method="post">
			<input style="margin-bottom: 5px;" class="form-control" type="text" name="username" placeholder="Username" required>
			<input style="margin-bottom: 5px;"class="form-control" type="password" name="password" placeholder="Password" required>
			<button style="width: 100%; margin-bottom: 5px;" class="btn btn-success" type="submit" name="Login">Login</button>
			<button style="width: 100%;" onClick="registerPage()" class="btn btn-warning" type="button" name="Login">Creaza un cont</button>
		</form>
	</div>
	<script>
		function registerPage(){
			window.location.href="register";
		}
	</script>
</body>
</html>