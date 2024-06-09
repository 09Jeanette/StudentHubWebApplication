<%-- 
    Document   : viewStudentsOtcome
    Created on : 09 Jun 2024, 7:16:27 PM
    Author     : Jeanette
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>class list Page</title>
    </head>
    <body>
        <h1>Class List!</h1>
        
        <%
        List<Student> list = (List<Student>)request.getAttribute("list");
        
        for(int i = 0 ; i < list.size();i++)
        {
            Student s = list.get(i);
            byte[] image = s.getImage();
          String imagebase64 = java.util.Base64.getEncoder().encodeToString(image);
         %>
              <table border="1">
            <tr>
                <td>Photo:</td>
                <td><img src="data:image/jpeg;base64,<%=imagebase64%>"></td>
            </tr>
            
             <tr>
                <td>Name:</td>
                <td><%= s.getName() %></td>
            </tr>
            
             <tr>
                <td>Surname:</td>
                <td><%= s.getSurname() %></td>
            </tr>
            
             <tr>
                <td>Student Number:</td>
                <td><%= s.getId() %></td>
            </tr>
            
             <tr>
                <td>Date:</td>
                <td><%= s.getDate() %></td>
            </tr>
        </table>
            
            
    
            <%
        }
        
        %>
        <p>Click <a href="menu.html">here</a> to go back to the menu.</p>
    </body>
</html>
