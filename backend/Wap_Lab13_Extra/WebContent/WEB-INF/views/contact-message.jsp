<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Contact Message Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href='css/footer-n-more.css' rel='stylesheet'>
</head>
<body>
<%@include file="/WEB-INF/fragments/header.jsp" %>

	<div class='container'>
		<p class='h2'>List of Contact Messages</p>
		
		<div>
			<table class="table table-striped" id="gridData">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Customer Name</th>
			      <th scope="col">Gender</th>
			      <th scope="col">Category</th>
			      <th scope="col">Message</th>
			    </tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="contact" items="${contactMessages}" varStatus="iteration">
			  			<tr>
			  				<th scope="row"><c:out value="${iteration.index+1}"></c:out></th>
			  				<td><c:out value="${contact.customerName}"></c:out></td>
			  				<td><c:out value="${contact.gender}"></c:out></td>
			  				<td><c:out value="${contact.category}"></c:out></td>
			  				<td><c:out value="${contact.message}"></c:out></td>
			  			</tr>
			  		</c:forEach>
			  </tbody>
			    
			</table>
			
			<nav aria-label="Page navigation">
			  <ul class="pagination">
			  <c:if test="${currentPage != 1}">
			    <li class="page-item">
			      <a class="page-link" href="contactmessage?page=${currentPage - 1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Previous</span>
			      </a>
			    </li>
			    </c:if>
			    <c:forEach begin="1" end="${noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${currentPage == i}">
			                        <c:if test="${noOfPages != 1}">
			                       		<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
			                       	</c:if>
			                    </c:when>
			                    <c:otherwise>
			                        <li class="page-item">
      									<a class="page-link" href="contactmessage?page=${i}">${i}</a>
    								</li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
			    
			    <c:if test="${currentPage lt noOfPages}">
			    <li class="page-item">
			      <a class="page-link" href="contactmessage?page=${currentPage + 1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			        <span class="sr-only">Next</span>
			      </a>
			    </li>
			    </c:if>
			  </ul>
			</nav>
			
		<br/>	
		</div>
		
	</div>
	
	
<%@include file="/WEB-INF/fragments/footer.jsp" %>

<!--  Add active font in navbar by jquery-->
<script>
	$("#index").removeClass("active");
	$("#contactMessage").addClass("active");
</script>
</body>
</html>