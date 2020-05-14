package miu.edu.cs.cs472.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThankYouServlet
 */
@WebServlet({ "/ThankYouServlet", "/thankyou" })
public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThankYouServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    response.setBufferSize(8192);
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		String message = request.getParameter("message");
		
		PrintWriter pw = response.getWriter();
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

			sb.append("<nav class='navbar navbar-expand-lg navbar-dark bg-primary navbar-custom navbar-collapse'>");
				sb.append("<a class='navbar-brand text-white'>CS472-WAP ::: Lab10</a>");
				sb.append("<button class='navbar-toggler' type='button' data-toggle='collapse'");
				sb.append("	data-target='#navbarSupportedContent'");
				sb.append("	aria-controls='navbarSupportedContent' aria-expanded='false'");
				sb.append("	aria-label='Toggle navigation'>");
				sb.append("	<span class='navbar-toggler-icon'></span>");
				sb.append("</button>");
				
			sb.append("</nav>");
			
			sb.append("<div class='container'>");
				sb.append("<p class='right' id='clock'></p>");
				sb.append("<div class='border'>");
					sb.append("<p class='h2  bg-light border'>Thank you! Your message has been received as follows:</p>");
					sb.append("<p class='h5'>Name: " + name +" </p>");
					sb.append("<p class='h7 text-muted'>Gender: " + gender +"</p>");
					sb.append("<p class='h7 text-muted'>Category: " + category + "</p>");
					sb.append("<p class='h6'>Message: " + message+ "</p>");
			
					sb.append("<br/><p>Please feel free to <a href='contactus'>Contact Us</a> again</p>");
			
				sb.append("</div>");
				
					sb.append("<div>");
					sb.append("<p class='text-muted' style='float: left;'>Hit Count for this page: " + request.getServletContext().getAttribute("countThankYou") +  "</p>");
					sb.append("<p class='text-muted' style='float: right;'> Hit Count for entire WebApp: " + request.getServletContext().getAttribute("countAll") + "</p>");
					sb.append("</div>");
				
			sb.append("</div>");
			
			
			sb.append("<footer class='footer'>");
				sb.append("<span class='text-muted'>O. Kalu:::CS472-WAP</span> <span");
					sb.append("class='text-muted right'>&copy; April 2020</span>");
			sb.append("</footer>");
			sb.append("<script defer src='js/web.js'></script>");
			sb.append("<script defer src='js/jquery-3.5.0.min.js'></script>");
			sb.append("<script src='https://code.jquery.com/jquery-3.4.1.slim.min.js'");
				sb.append("integrity='sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n'");
				sb.append("crossorigin='anonymous'></script>");
			sb.append("<script");
				sb.append("src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'");
				sb.append("integrity='sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo'");
				sb.append("crossorigin='anonymous'></script>");
			sb.append("<script");
				sb.append("src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js'");
				sb.append("integrity='sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6'");
				sb.append("crossorigin='anonymous'></script>");
		sb.append("</body>");
		sb.append("</html>");

		pw.println(sb);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
