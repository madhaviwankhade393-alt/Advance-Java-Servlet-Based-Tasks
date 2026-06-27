package controller;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContactModel;
import phbook.dto.Contact;


import java.io.IOException;
import java.util.List;


@WebServlet("/ViewContactController")
public class ViewContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 ContactModel model = new ContactModel();
	        List<Contact> contacts =  model.getAll();

	        request.setAttribute("contactList", contacts);
	        RequestDispatcher rd = request.getRequestDispatcher("view-contact.jsp");
	        rd.forward(request, response);
		
		
		
	}

}
