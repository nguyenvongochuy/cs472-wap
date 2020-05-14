"use strict";

$(document).ready(function(){
		$("#lnkBtnNewBookOrClose").on("click", toggleCloseOrAddNewBook);
		$("#addBookForm").on("submit", addNewBook);
		
		getBooks();
		
		function getBooks() {
			$.ajax({
				  type: "GET",  
				  url: "https://elibraryrestapi.herokuapp.com/elibrary/api/book/list",
				  dataType: "json",
				  success: function(data) {
					  if (data.length===0) {
				    		$("#gridContent").append("No record found.")
				    	} else {
					    	let books="";
					    	data = sortByKeyAsc(data, "bookId");
					    	$.each(data, function(i, item) {
					    		books += 
									`<tr id="${item.bookId}">
							    			<td>${item.bookId}</td>
							    			<td>${item.isbn}</td>
							    			<td>${item.title}</td>
							    			<td>${item.overdueFee}</td>
							    			<td>${item.publisher}</td>
							    			<td>${item.datePublished}</td>
							  		</tr>`;
					    		
					    	});
					    	$("#gridContent").append(books);
				    	}
				  },
				  error: function(e) {
					  //console.log("getBooks error:" + sender + " " + message + "  " + details);
					  alert("fail: " + e);
				  }
				});
			
			
		};
		
		
		
		/*
		const getBooks = function(url) {
			    return $.ajax({
			        type: "GET",
			        url: url,
			        dataType: "json",
			        contentType: "application/json;charset=utf-8"
			    });
		}	
		
		getBooks("https://elibraryrestapi.herokuapp.com/elibrary/api/book/list")
		    .done(function(data){ //read book items and display table
		        //console.log(data);
		    	//alert("RUN getBookExecute");
		    	if (data.length===0) {
		    		$("#gridContent").append("No record found.")
		    	} else {
			    	let books="";
			    	data = sortByKeyAsc(data, "bookId");
			    	$.each(data, function(i, item) {
			    		books += 
							`<tr id="${item.bookId}">
					    			<td>${item.bookId}</td>
					    			<td>${item.isbn}</td>
					    			<td>${item.title}</td>
					    			<td>${item.overdueFee}</td>
					    			<td>${item.publisher}</td>
					    			<td>${item.datePublished}</td>
					  		</tr>`;
			    		
			    	});
			    	$("#gridContent").append(books);
		    	}
		   })
		    .fail(function(sender, message, details){
		           console.log("getBooks error:" + sender + " " + message + "  " + details);
	  });
		
		*/
		
		
		// Toggle (display/hide) the form
		   function toggleCloseOrAddNewBook(e) {
		        e.preventDefault();
		        const formstate = $("#lnkBtnNewBookOrClose").attr("data-formstate");
		        if(formstate == "off") {
		        	$("#pageTitle").text("Add New Book");
		            $("#lnkBtnNewBookOrClose").text("Close");
		            $("#divNewBookForm").show("slow");
		            $("#bookTitle").focus();
		            $("#lnkBtnNewBookOrClose").attr("data-formstate", "on");
		        } else {
		        	$("#pageTitle").text("Books in our Collection");
		            $("#lnkBtnNewBookOrClose").text("Add New Book");
		            $("#divNewBookForm").hide("slow");
		            $("#lnkBtnNewBookOrClose").attr("data-formstate", "off");
		        }
		    };
		

			/* POST method to add */
			const makePostCall = function (url, data) { 
				   var json_data = JSON.stringify(data);
		
				    return $.ajax({
				        type: "POST",
				        url: url,
				        data: json_data,
				        dataType: "json",
				        contentType: "application/json;charset=utf-8"
				    });
				}
		    
		//Add new Book
		function addNewBook(e) {
			e.preventDefault();
			//build JSON object literal from Form submitted
			const buildJSONObject = {
					isbn: $("#isbn").val(),
					title: $("#bookTitle").val(),
					overdueFee: $("#overdueFee").val(),
					publisher: $("#publisher").val(),
					datePublished: $("#datePublished").val()
			};
			//alert(`Added new book '${buildJSONObject.isbn}' successfully`);
			
			
			makePostCall("https://elibraryrestapi.herokuapp.com/elibrary/api/book/add", buildJSONObject)
		    .done(function(data){
		    	clearForm();
		        alert(`Added new book '${buildJSONObject.isbn}' successfully`);
		        getBooks();
		   })
		    .fail(function(sender, message, details){
		    	console.log("addBook error:" + sender + " " + message + "  " + details);
		  });
		  
		  
		}
		
		function clearForm(){
			$("#isbn").val("");
			$("#bookTitle").val("");
			$("#overdueFee").val("");
			$("#ssn").val("");
			$("#publisher").val("");
			$("#datePublished").val("");
			$("#bookTitle").focus();
		}
		
		
		//----------------- Utilities function
		function sortByKeyDesc(array, key) {
		    return array.sort(function (a, b) {
		        var x = a[key]; var y = b[key];
		        return ((x > y) ? -1 : ((x < y) ? 1 : 0));
		    });
		}
		function sortByKeyAsc(array, key) {
		    return array.sort(function (a, b) {
		        var x = a[key]; var y = b[key];
		        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
		    });
		}
	//}
});


