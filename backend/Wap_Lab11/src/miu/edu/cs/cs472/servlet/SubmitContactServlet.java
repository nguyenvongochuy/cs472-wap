package miu.edu.cs.cs472.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitContactServlet
 */
@WebServlet({ "/SubmitContactServlet", "/submitcontact" })
public class SubmitContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitContactServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String category = request.getParameter("category");
		String message = request.getParameter("message");
		
		String validationFieldSuccess = validationFieldSuccess(name, gender, category, message);
		if (!validationFieldSuccess.equals("")) {
			// display error in each field and forward to contactUs form
			request.setAttribute("error", validationFieldSuccess);
			request.getRequestDispatcher("contactus").forward(request, response);
			
		} else {
			//redirect to greeting page
			String url = "thankyou?name=" + name + "&gender=" + gender
					+ "&category=" + category + "&message=" + message;
			response.sendRedirect(url);
		}
	}

	private String validationFieldSuccess(String name, String gender, String category, String message) {
		StringBuilder sb = new StringBuilder();
		String result;
		String error = " is missing.";		
		if (name == null || name.equals("")) {
			sb.append("<p>" + "Name" + error + "</p>");
		}
		if (gender == null || gender.equals("")) {
			sb.append("<p>" + "Gender" + error + "</p>");
		}
		if (category == null || category.equals("")) {
			sb.append("<p>" + "Category" + error + "</p>");
		}
		if (message == null || message.equals("")) {
			sb.append("<p>" + "Message" + error + "</p>");
		}
		result = sb.toString();
		
		return result;
	}
	


}
