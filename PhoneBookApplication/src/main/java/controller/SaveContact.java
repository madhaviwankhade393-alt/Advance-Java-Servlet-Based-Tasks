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


@WebServlet("/SaveContact")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String name = request.getParameter("name");
	        String contact = request.getParameter("contact");
	        String blocked = request.getParameter("blocked");
	        boolean blockFlag = blocked != null; // block is null = false, block not null = true

	        Contact contactObject = new Contact();
	        contactObject.setName(name);
	        contactObject.setPhNumber(contact);
	        contactObject.setBlocked(blockFlag);

	        ContactModel contactModel = new ContactModel();
	        boolean result = contactModel.save(contactObject);
	        String mesage = result ? "created" : "fail";
	        response.sendRedirect("new-contact.jsp?msg="+mesage);
		
		
	 	
		
		 
	}

}
