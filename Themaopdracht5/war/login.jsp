<html lang="en-US">
<head>

<meta charset="utf-8">

<title>Login</title>

<link rel="stylesheet" href="Style.css">
<link rel="stylesheet" href="css/layout.css">
<script src="js/jquery-1.5.2.min.js"></script>
<script>
$(document).ready(function() {
    $('#bg').fadeIn("slow");
});	

</script>


</head>

<body>
<div id="bg"></div>
<div id="bg2"></div>
	<div id="login">

		<h2>
			<span class="fontawesome-lock"></span>Accent Nijkerk Login
		</h2>

		<form action="LoginServlet.do" method="POST">

			<fieldset>

				<div id="roww">
					<label for="text">Username:</label>
				</div>
				<div id="roww">
					<input type="text" name="username" value="username"
						onBlur="if(this.value=='')this.value='username'"
						onFocus="if(this.value=='username')this.value=''" autofocus>
				</div>
				

				<div id="roww">
					<label for="password">Password</label>
				</div>
				<div id="roww">
					<input type="password" name="password" value="password"
						onBlur="if(this.value=='')this.value='password'"
						onFocus="if(this.value=='password')this.value=''">
				</div>
				

				<div id="roww">
				
					<input type="submit" class="btn btn-success" value="Login">
					<a href="register.jsp" value="Register">Register</a>
				</div>
		
			</fieldset>

		</form>
		
	</div>
	<!-- end login -->

</body>
</html>