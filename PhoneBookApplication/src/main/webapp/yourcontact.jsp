<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%@ include file='menu.jsp' %>
<%@ page import="phbook.dto.Contact" %>
<%
     Contact ct =(Contact)request.getAttribute("ct"); 
%>

<div class="container mt-3">
 <h2>Search Contact</h2>

  <table class="table table-hover">
    <thead class="table-success ">
      <tr>
        <th>Name</th>
        <th>Contact Number</th>
        <th>Blocked</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody> 
              <tr>
                  <td><%= ct.getName() %></td>
                  <td><%= ct.getPhNumber() %></td>
                  <td><%= ct.isBlocked()? "Yes" :"No" %></td>
                  <td>
                    <a href="edit-contact?id=<%= ct.getId() %>">
                      <span class="glyphicon glyphicon-edit"></span>
                    </a>
                     <a href="DeleteContact?id=<%= ct.getId() %>">
                        <span class="glyphicon glyphicon-trash"></span>
                      </a>
                  </td>
              </tr>
    </tbody>
  </table>
</div>

</body>
</html>