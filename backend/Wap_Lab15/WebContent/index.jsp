<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>The eLibrary ::: CS472-WAP - Lab15 (JSON, AJAX)</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="css/footer-n-more.css" rel="stylesheet">

</head>

<body>
<%@include file="/WEB-INF/fragments/header.jsp" %>

	<div class='container bg-light'>
		<p class='h1 linebreak'>Welcome to the eLibrary&reg;</p>
		<p><img class="responsive"  alt="elibrary" src="images/elibrary.jpg"  /></p>
		<p>The eLibrary System is a locally-networked repository system suitable for organizations or places where the interweb is non-existent or at best spotty. </p>
		<p>In other words, we are a FULL SERVICE CORPORATE ADVISORY FIRM. We say so because we are a team of all kinds of corporate advisory professionals. Company Secretaries, Chartered Accountants, Advocates etc.
		 </p>
		<!--  
		<p>It use utility classed for typography and spacing to space content out within the larger container.</p>
					<form id='learnMore' method='get' action='#'>
					<div class='form-group'>
						<input class='btn btn-primary btn-sm navbar-custom'
							type='submit' value='Learn more' />
					</div>
					</form>
		-->			
	</div>
	
<%@include file="/WEB-INF/fragments/footer.jsp" %>

<!--  Add active font in navbar by jquery-->
<script>
	$("#index").addClass("active");
	$("#book").removeClass("active");
</script>
</body>
</html>
