package model;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phbook.dto.Contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/DeleteContact")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		System.out.println(id); 
		 int id1=Integer.parseInt(id);
		Boolean result=DeleteContact.delete(id1);
	      String message = result ? "Deleted" : "fail";
	      
	      ContactModel model = new ContactModel();
	      
	        List<Contact> contacts =  model.getAll();

	        request.setAttribute("contactList", contacts);
	        RequestDispatcher rd = request.getRequestDispatcher("view-contact.jsp?msg="+message); 
	        rd.forward(request, response);

	}

	public static boolean delete(int id) {
		
		
		 boolean result = false;
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/msvdb?useSSL=false","root","300805");
	            PreparedStatement psmt = connection.prepareStatement("delete from phbook where id=? ");
	            psmt.setInt(1, id);
	            int count = psmt.executeUpdate();
	            result = count>0;
	            connection.close();
	        } catch (Exception e) { 
	            e.printStackTrace();
	        }
	        return result;
	  
	}
	
	
	public static Connection getDBConnection() 
	{ 
Connection con=null; 
	try { 
Class.forName("com.mysql.cj.jdbc.Driver"); /*Driver Registration   */
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/msvdb?useSSL=false","root","300805");/* Create connection*/
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch(SQLException e) {
			e.printStackTrace();
		}
return con;
} 
}
