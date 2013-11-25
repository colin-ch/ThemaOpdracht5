<html lang="en-US">
<head>

<meta charset="utf-8">

<title>Login</title>

<link rel="stylesheet" href="Style.css">
<script lang="javascript">
	function validateForm() {
		var pwd1 = document.forms["RegisterForm"]["password"].value;
		var pwd2 = document.forms["RegisterForm"]["passcheck"].value;
		if (pwd1 != pwd2) {
			alert("Please, enter the same password twice");
			
			return false;
		}
	}
</script>

</head>

<body>
	<div id="login">
		<h2>
			<span class="fontawesome-lock"></span>Register
		</h2>
		<form name="RegisterForm" action="RegisterServlet.do" method="POST"
			onsubmit="return validateForm()">
			<fieldset>
				<p>
					<label for="text">Username:</label>
				</p>
				<p>
					<input type="text" name="username" value="" autofocus required>
				</p>
				<p>
					<label for="password">Password:</label>
				</p>
				<p>
					<input type="password" name="password1" id="password" value=""
						required>
				</p>
				<p>
					<label for="password">Password check:</label>
				</p>
				<p>
					<input type="password" name="password2" id="passcheck" value=""
						required>
				</p>
				<p>
					<label for="email">Email:</label>
				</p>
				<p>
					<input type="email" name="email1" value="" required>
				</p>

				<!-- JS because of IE support; better: placeholder="password" -->
				<p>
					<input type="submit" value="Register">
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