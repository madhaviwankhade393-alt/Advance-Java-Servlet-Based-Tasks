package model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phbook.dto.Contact;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		  request.setAttribute("ct",  Search.Search(name));
	        RequestDispatcher rd = request.getRequestDispatcher("yourcontact.jsp"); 
	        rd.forward(request, response);

		  
		
		
		
		
		
		
	}
	public static Contact Search(String name) {
		 Contact ct = new Contact();
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/msvdb?useSSL=false","root","300805");
	            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM phbook where name=?");
	            stmt.setString(1, name);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	               
	                ct.setId(rs.getInt("id"));
	                ct.setName(rs.getString("name"));
	                ct.setPhNumber(rs.getString("phnumber"));
	                ct.setBlocked(rs.getBoolean("blocked"));
	                ct.setCreatedOn(rs.getString("createdon"));
	            }
	            
	            connection.close();
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
		return ct; 
	}

}
