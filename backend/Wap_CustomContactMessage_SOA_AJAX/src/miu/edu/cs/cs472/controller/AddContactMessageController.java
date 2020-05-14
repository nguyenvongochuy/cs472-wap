package miu.edu.cs.cs472.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import miu.edu.cs.cs472.model.ContactMessage;
import miu.edu.cs.cs472.service.ContactMessageService;

/**
 * Servlet implementation class InsertContactMessageController
 */
@WebServlet({ "/InsertContactMessageController", "/add", "/insert" })
public class AddContactMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactMessageService contactMessageService = new ContactMessageService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactMessageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
				// received JSON data from request
				StringBuffer sb = new StringBuffer();
				String line = null;
				try {
					BufferedReader br = request.getReader();
					line = br.readLine();
					while (line!= null) {
						sb.append(line);
						//System.out.println("line: " + line);
						line = br.readLine();
					}
					//System.out.println("Stringbuffer: " + sb);
					String newContactMessageRecord = sb.toString();
					//System.out.println(newContactMessageRecord);
					Gson gson = new Gson();
					System.out.println("GO to Post of ADD: " + newContactMessageRecord);
					ContactMessage contactMessage = gson.fromJson(newContactMessageRecord, ContactMessage.class);
					System.out.println(contactMessage);
					contactMessageService.addContactMessage(contactMessage);
				} catch (Exception e) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					response.getWriter().println(e.toString());
				}
		
		
	}
	
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
