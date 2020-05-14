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
		<p class='h2 color'><span id="pageTitle">Books in our Collection</span>
		<!--  <input class="btn btn-outline-success rightfloat" data-formstate="off" type="button" value="Add New Book" id="addBook"/>-->
		<a id="lnkBtnNewBookOrClose" data-formstate="off" class="btn btn-outline-success rightfloat" href="#">Add New Book</a>
		</p>
		
		<!-- New Book Form -->
        <div id="divNewBookForm" style="display: none;">
            <form id="addBookForm">
                <fieldset>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="bookTitle">*Book Title</label>
                                    <input tabindex="1" id="bookTitle" name="bookTitle" type="text" class="form-control"
                                           aria-describedby="bookTitleHelp" value="" required autofocus placeholder=""/>
                                </div>
                            </div>
                         </div>   
                         <div class="row"> 
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="isbn">*ISBN</label>
                                    <input tabindex="2" id="isbn" name="isbn" type="text" class="form-control" value="" required/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="overdueFee">*Overdue Fee per day</label>
                                    <input tabindex="3" id="overdueFee" name="overdueFee" type="text" class="form-control" value="" required  placeholder="0.00"/>
                                    <small id="overdueFeeHelp" class="form-text text-muted">Enter a valid decimal amount; in dollars and cents; no comma (e.g. 1.99)</small>
                                </div>
                            </div>
                          </div>  
                          <div class="row"> 
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="publisher">*Publisher</label>
                                    <input tabindex="4" id="publisher" name="publisher" type="text" class="form-control" value="" required />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="datePublished">*Date of Birth:</label>
                                    <input tabindex="5" id="datePublished" name="datePublished" type="date" class="form-control" value="" required />
                                </div>
                            </div>
                          </div> 
    
                        <div class="row">
                            <div class="col-md-6">
                                <div>&nbsp;</div>
                            </div>
                            <div class="col-md-6">
                                <div class="rightfloat">
                                    <button  tabindex="9" id="btnReset" type="reset" class="btn btn-outline-danger">Reset</button>
                                    &nbsp;
                                    <button tabindex="10" id="btnSaveBook" type="submit" class="btn btn-outline-success">Save Book</button>
                                </div>
                            </div>
                        </div>
                    </div>    
                </fieldset>
            </form>            
        </div>
        <!-- End Form -->
		
		<!--  Grid section -->
		<div>
			<table class="table table-striped" id="gridData">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">ISBN</th>
			      <th scope="col">Book Title</th>
			      <th scope="col">Overdue Fee</th>
			      <th scope="col">Publisher</th>
			      <th scope="col">Date Publisher</th>
			    </tr>
			  </thead>
			  
			  <tbody id= "gridContent">
			  </tbody>
			    
			</table>
			
		<br/>	
		</div>
		
	</div>
	
	
<%@include file="/WEB-INF/fragments/footer.jsp" %>
<script defer src='js/web.js'></script>
<!--  Add active font in navbar by jquery-->
<script>
	$("#index").removeClass("active");
	$("#book").addClass("active");
</script>
</body>
</html>