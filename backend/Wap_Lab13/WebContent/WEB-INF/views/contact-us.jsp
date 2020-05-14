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
		<p class='h3 linebreak'>Customer Contact Form</p>

		${errorMessage}
		
		<form id='contactUsForm' method='POST' action='submitcontact'>
			<div class='row'>
				<div class='col-sm-12'>
					<div class='form-group'>
						<label for='name'>*Name:</label> <input type='text'
							class='form-control' id='name' name='name'
							placeholder='e.g. John Smith' value="${contactMessage.customerName}"> 
							<small id='nameHelp' class='form-text text-muted'>Enter your full name.</small>
					</div>
					<div class='form-group'>
						<label for='gender'>*Gender:</label><br /> 
						<label><input type='radio' id='genderMale' name='gender' value='Male' ${contactMessage.gender.equals("Male") ? "checked" : ""} >Male</label>
						<label><input type='radio' id='genderFemale' name='gender' value='Female' ${contactMessage.gender.equals("Female") ? "checked" : ""} >Female</label>
					</div>
					<div class='form-group'>
						<label for='category'>*Category:</label> <select
							class='form-control' id='category' name='category'>
							<option value=''>Select...</option>
							<option value='Feedback' ${contactMessage.category.equals("Feedback") ? "selected" : ""}>Feedback</option>
							<option value='Inquiry' ${contactMessage.category.equals("Inquiry") ? "selected" : ""}>Inquiry</option>
							<option value='Complaint' ${contactMessage.category.equals("Complaint") ? "selected" : ""}>Complaint</option>
						</select>
					</div>
					<div class='form-group'>
						<label for='message'>*Message:</label>
						<textarea class='form-control' id='message' name='message'>${contactMessage.message}</textarea>
					</div>
					<div class='form-group'>
						<input class='btn btn-primary btn-sm navbar-custom btn-block'
							type='submit' value='Submit' />
					</div>
				</div>
			</div>
		</form>

		<div>
			<p class='text-muted' style='float: left'>Hit Count for this page: ${countSubmitContact}</p>
			<p class='text-muted' style='float: right'>Hit Count for entire WebApp: ${countAll}</p>
		</div>

	</div>
	<br />
	<br />
	<br />

	<%@include file="/WEB-INF/fragments/footer.jsp"%>
	<script>
		$("#index").removeClass("active");
		$("#contactUs").addClass("active");
	</script>
</body>
</html>
