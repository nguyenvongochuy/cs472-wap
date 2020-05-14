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
 * Servlet implementation class SearchController
 */
@WebServlet({ "/SearchController", "/search" })
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int RECORDS_PER_PAGE = 5;
	private ContactMessageService contactMessageService = new ContactMessageService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		/*
		String searchValue = request.getParameter("searchValue");
		
		int page = 1;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        List<ContactMessage> list = contactMessageService.getContactMessagesSearchByKeyword(searchValue);
        request.getSession().setAttribute("contactMessagesAll", list);
        List<ContactMessage> subList = contactMessageService.getContactMessagesSortedByIndex(list,
        							(page-1)*RECORDS_PER_PAGE, RECORDS_PER_PAGE);
        int noOfRecords = contactMessageService.getNoOfRecords(list);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / RECORDS_PER_PAGE);
        
        request.setAttribute("contactMessages", subList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
		*/
		request.getRequestDispatcher("/WEB-INF/views/contact-message.jsp").forward(request, response);
	}

}
