"use strict";

/* (DOM, JQUERY, INHERITANCE) Lab */
/**
* Prob 4: use form with jQuery
*/

$(document).ready(function(){
	/* add event and run for loginForm with submitButton */
	$("#loginForm").on("submit", loginForm);
	
	/* add event and run for Product form */
	$("#productForm").on("submit",  submitProduct);



function loginForm(e) {
	const email = $("#inputEmail").val();
	const password = $("#inputPassword").val();
	console.log("Email: " + email);
	console.log("Password: " + password);
	e.preventDefault();
}

function submitProduct(e){
	const productNumber = $("#productNumber").val();
	const name = $("#name").val();
	const unitPrice = $("#unitPrice").val();
	const quantity = $("#quantity").val();
	const supplier = $("#supplier").val();
	const dateSupplied = $("#dateSupplied").val();
		
	/* build div and display below form */
	let newDivTag = "<div><ul>" +
						"<li>Product Number: " + productNumber + "</li>" +
						"<li>Name: " + name + "</li>" +
						"<li>Unit Price: " + unitPrice + "</li>" +
						"<li> Quantity: " + quantity + "</li>" +
						"<li>Supplier: " + supplier + "</li>" +
						"<li>Date Supplied: " + dateSupplied + "</li>" +
						"<div><ul>";
	$("#productForm").append(newDivTag);
	e.preventDefault();
}	

}); //no global windows objects of function