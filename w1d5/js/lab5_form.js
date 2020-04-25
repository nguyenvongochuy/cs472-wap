"use strict";


/**
 * 
14.	Refer to your work on Lab Assignment 4. Add Javascript code to work with your 2 HTML forms as follows:
a.	Login Form: Add code such that when the Submit button is clicked, the values entered in the input fields 
are printed to the Console.
b.	New Product Form: Add code such that when the Submit button is clicked, the values entered 
in the input fields are displayed in a pop-up window.
 */

function printLogin(event) {
	event.preventDefault();
	let email = document.getElementById("inputEmail");
	let password = document.getElementById("inputPassword");
	console.log("Prob13: You entered email: " + email.value);
	console.log("Prob13: You entered password: " + password.value);
}

function alertProduct(event) {
	event.preventDefault();
	let productNumber = document.getElementById("productNumber");
	let name = document.getElementById("name");
	let unitPrice = document.getElementById("unitPrice");
	let quantity = document.getElementById("quantity");
	let supplier = document.getElementById("supplier");
	let date = document.getElementById("dateSupplied");
	
	alert("productNumber: " + productNumber.value + "\n" + 
			"name: " + name.value + "\n" + 
			"unitPrice: " + unitPrice.value + "\n" +
			"quantity: " + quantity.value + "\n"  +
			"supplier: " + supplier.value + "\n" + 
			"dateSupplied: " + date.value + "\n");
	

}
