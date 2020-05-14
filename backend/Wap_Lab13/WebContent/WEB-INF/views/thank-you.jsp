<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Contact Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href='css/footer-n-more.css' rel='stylesheet'>

</head>

<body>
	<%@include file="/WEB-INF/fragments/header.jsp"%>


				<div class='container'>
				<p class='right' id='clock'></p>
				<div class='border'>
					<p class='h2  bg-light border'>Thank you! Your message has been received as follows:</p>
					<p class='h5'>Name: ${contactMessage.customerName} </p>
					<p class='h7 text-muted'>Gender: ${contactMessage.gender}</p>
					<p class='h7 text-muted'>Category: ${contactMessage.category}</p>
					<p class='h6'>Message: ${contactMessage.message}</p>
			
					<br/><p>Please feel free to <a href='contactus'>Contact Us</a> again</p>
			
				</div>
				
					<div>
					<p class='text-muted' style='float: left;'>Hit Count for this page: ${countThankYou}</p>
					<p class='text-muted' style='float: right;'> Hit Count for entire WebApp: ${countAll}</p>
					</div>
				
			</div>
	

	<%@include file="/WEB-INF/fragments/footer.jsp"%>
	<script>
		$("#index").removeClass("active");
		$("#contactUs").addClass("active");
	</script>
</body>
</html>
