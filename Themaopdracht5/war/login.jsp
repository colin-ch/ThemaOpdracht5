<html lang="en-US">
<head>

<meta charset="utf-8">

<title>Login</title>

<link rel="stylesheet" href="Style.css">
<link rel="stylesheet" href="css/layout.css">


</head>

<body>

	<div id="login">

		<h2>
			<span class="fontawesome-lock"></span>Sign In
		</h2>

		<form action="LoginServlet.do" method="POST">

			<fieldset>

				<p>
					<label for="text">Username:</label>
				</p>
				<p>
					<input type="text" name="username" value="username"
						onBlur="if(this.value=='')this.value='username'"
						onFocus="if(this.value=='username')this.value=''" autofocus>
				</p>
				

				<p>
					<label for="password">Password</label>
				</p>
				<p>
					<input type="password" name="password" value="password"
						onBlur="if(this.value=='')this.value='password'"
						onFocus="if(this.value=='password')this.value=''">
				</p>
				

				<p>
				<a href="#" class="btn btn-success"><i class="icon-white icon-circle-arrow-right"></i> Login</a>
		
					<input type="submit" value="Sign In">
					<a href="register.jsp" value="Register">Register</a>
				</p>
		
			</fieldset>

		</form>
		
	</div>
	<!-- end login -->

</body>
</html>