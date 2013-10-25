<html lang="en-US">
<head>

<meta charset="utf-8">

<title>Login</title>

<link rel="stylesheet" href="Style.css">

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
				<!-- JS because of IE support; better: placeholder="mail@address.com" -->

				<p>
					<label for="password">Password</label>
				</p>
				<p>
					<input type="password" name="password" value="password"
						onBlur="if(this.value=='')this.value='password'"
						onFocus="if(this.value=='password')this.value=''">
				</p>
				<!-- JS because of IE support; better: placeholder="password" -->

				<p>
					<input type="submit" value="Sign In">
					<a href="register.jsp" value="Register">Register</a>
				</p>
			<% 
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) { 
			out.println(msgs);
			}
			%>
			</fieldset>

		</form>
		
	</div>
	<!-- end login -->

</body>
</html>