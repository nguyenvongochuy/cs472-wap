<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Contact Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='css/footer-n-more.css' rel='stylesheet'>

</head>

<body>
<%@include file="/WEB-INF/fragments/header.jsp" %>

	<div class='container bg-light'>
		<p class='h1'>Hello, world of HttpServlet 4.0!</p>
		<p class='h4'>Welcome to Lab 13 - MVC JSP</p>
		<p class='linebreak'>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>

		<p>It use utility classed for typography and spacing to space content out within the larger container.</p>
					<form id='learnMore' method='get' action='#'>
					<div class='form-group'>
						<input class='btn btn-primary btn-sm navbar-custom'
							type='submit' value='Learn more' />
					</div>
					</form>
	</div>
<%@include file="/WEB-INF/fragments/footer.jsp" %>
<script>
	$("#index").addClass("active");
	$("#contactMessage").removeClass("active");
</script>
</body>
</html>
