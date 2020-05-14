package miu.edu.cs.cs472.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet({"/ContactUsServlet", "/ContactUs", "/contactus"})
public class ContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    response.setBufferSize(8192);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang='en'>");
				sb.append("<head>");
						sb.append("<meta charset='utf-8'>");
								sb.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
										sb.append("<title>Contact Us</title>");
				    sb.append("<link href='css/bootstrap.min.css' rel='stylesheet'>");
				    sb.append("<link href='css/footer-n-more.css' rel='stylesheet'>");
				    
				    		sb.append("</head>");

				    				sb.append("<body>");

				  sb.append("<nav class='navbar navbar-expand-lg navbar-dark bg-primary navbar-custom navbar-collapse' >");
				  sb.append("<a class='navbar-brand text-white'>CS472-WAP ::: Lab10</a>");
				  sb.append("<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarSupportedContent' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>");
				  sb.append("<span class='navbar-toggler-icon'></span>");
				  sb.append("</button>");
						  sb.append("<div class='collapse navbar-collapse' id='navbarSupportedContent'>");
						  sb.append("<ul class='navbar-nav mr-auto'>");
						  sb.append("<li class='nav-item'>");
							  sb.append("<a class='nav-link vertical' href='index.html'>Home</a>");
							  sb.append("</li>");
							  sb.append("<li class='nav-item'>");
						  sb.append("<a class='nav-link vertical' href='#'>About</a>");
							  sb.append("</li>");
							  sb.append("<li class='nav-item active'>");
							  sb.append("<a class='nav-link vertical' href='#'>Contact Us</a>");
								  sb.append("</li>");
								  sb.append("</ul>");
								  sb.append("<form class='form-inline my-2 my-lg-0'>");
								  sb.append("<input class='form-control mr-sm-2' type='search' placeholder='Search' aria-label='Search'>");
								  sb.append("<button class='btn btn-outline-success my-2 my-sm-0 btn-dark text-white' type='submit'>Search</button>");
								  sb.append("</form>");
											  sb.append("</div>");
											  sb.append("</nav>");
												  sb.append("<div class='container'>");
													    	sb.append("<p class='h3 linebreak'>Customer Contact Form</p>");
													    	
													    	//Add field validation section
													    	String name = request.getParameter("name")==null?"":request.getParameter("name");
															String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
															String category = request.getParameter("category")==null?"":request.getParameter("category");
															String message = request.getParameter("message")==null?"":request.getParameter("message");
													    	
													    	Object errorMsg = request.getAttribute("error");
													    	if (errorMsg!=null) {
														    	if (!errorMsg.equals("")) {
														    		sb.append("<div style='color: red;'>" + errorMsg + "</div>");
														    	}
													    	}
													    	
														sb.append("<form id='productForm' method='POST' action='submitcontact'>");
													  sb.append("<div class='row'>");
												  sb.append("<div class='col-sm-12'>");
										    	sb.append("<div class='form-group'>");
										    	sb.append("<label for='name'>*Name:</label>");
									   		sb.append("<input type='text' class='form-control' id='name' name='name' placeholder='e.g. John Smith' value='" + name +  "'>");
												   		sb.append("<small id='nameHelp' class='form-text text-muted'>Enter your full name.</small>");
											    	sb.append("</div>");
											    	sb.append("<div class='form-group'>");
											      sb.append("<label for='gender'>*Gender:</label><br/>");
												  sb.append("<label><input type='radio' id='genderMale' name='gender' value='Male' " + (gender.equals("Male")?"checked":" ")  +  ">Male</label>");
												  sb.append("<label><input type='radio' id='genderFemale' name='gender' value='Female' " + (gender.equals("Female")?"checked":" ")  +  ">Female</label>");
											 	sb.append("</div>");
											  	sb.append("<div class='form-group'>");
											     sb.append("<label for='category'>*Category:</label>");
											    sb.append("<select class='form-control' id='category' name='category'>");
											      sb.append("<option value=''>Select...</option>");
											      sb.append("<option value='Feedback' " + (category.equals("Feedback")?"Selected ":"") +   ">Feedback</option>");
											      sb.append("<option value='Inquiry' " + (category.equals("Inquiry")?"Selected ":"") +  ">Inquiry</option>");
											      sb.append("<option value='Complaint' "  + (category.equals("Complaint")?"Selected ":"") + ">Complaint</option>");
											  sb.append(" </select>");
											 sb.append("</div>");
											sb.append("<div class='form-group'>");
											  	sb.append("<label for='message'>*Message:</label>");
													sb.append("<textarea class='form-control' id='message' name='message'>" + message + "</textarea>");
											    sb.append("</div>    	");
												  sb.append("<div class='form-group'>");
												sb.append("<input class='btn btn-primary btn-sm navbar-custom btn-block' type='submit' value='Submit' />");
												  sb.append("</div>");
												sb.append("</div>");
												sb.append("</div>	");	 
												sb.append("</form>");
												
												 sb.append("<div>");
													sb.append("<p class='text-muted' style='float: left;'>Hit Count for this page: " + request.getServletContext().getAttribute("countSubmitContact") +  "</p>");
													sb.append("<p class='text-muted' style='float: right;'> Hit Count for entire WebApp: " + request.getServletContext().getAttribute("countAll") + "</p>");
													sb.append("</div>");
												
												sb.append("</div>");
												sb.append("<br/><br/><br/>");
												
												 
							    sb.append("<footer class='footer'>");
											        sb.append("<span class='text-muted'>O. Kalu:::CS472-WAP</span>");
											        sb.append("<span class='text-muted right'>&copy; April 2020</span>");
												    sb.append("</footer>");
													//sb.append("<script defer src='js/jquery-3.5.0.min.js'></script>");
								//sb.append("<script defer src='js/web.js'></script>");
				sb.append("<script src='https://code.jquery.com/jquery-3.4.1.slim.min.js' integrity='sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n' crossorigin='anonymous'></script>");
			sb.append("<script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js' integrity='sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo' crossorigin='anonymous'></script>");
			sb.append("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js' integrity='sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6' crossorigin='anonymous'></script>");
		  sb.append("</body>");
		sb.append("</html>");										
			PrintWriter printWrite = response.getWriter();
		printWrite.println(sb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
