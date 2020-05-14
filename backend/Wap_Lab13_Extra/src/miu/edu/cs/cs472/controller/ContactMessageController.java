package miu.edu.cs.cs472.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miu.edu.cs.cs472.model.ContactMessage;
import miu.edu.cs.cs472.service.ContactMessageService;

/**
 * Servlet implementation class ContactMessageController
 */
@WebServlet({ "/ContactMessageController", "/contactmessage" })
public class ContactMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int RECORDS_PER_PAGE = 5;
    
	private ContactMessageService contactMessageService = new ContactMessageService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactMessageController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ContactMessage> list = null;
		int page = 1;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            list = (List<ContactMessage>) request.getSession().getAttribute("contactMessagesAll");
        } else {
        	list = contactMessageService.getContactMessagesSorted();
            request.getSession().setAttribute("contactMessagesAll", list);
        }
        
        List<ContactMessage> subList = contactMessageService.getContactMessagesSortedByIndex(list, (page-1)*RECORDS_PER_PAGE, RECORDS_PER_PAGE);
        int noOfRecords = contactMessageService.getNoOfRecords(list);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / RECORDS_PER_PAGE);
        
        request.setAttribute("contactMessages", subList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
		
		request.getRequestDispatcher("/WEB-INF/views/contact-message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
