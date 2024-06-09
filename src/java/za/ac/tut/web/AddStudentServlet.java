/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.bl.StudentFacadeLocal;
import za.ac.tut.entities.Student;

/**
 *
 * @author Jeanette
 */
@MultipartConfig
public class AddStudentServlet extends HttpServlet {
@EJB
private StudentFacadeLocal sfl;
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        Part filePart = request.getPart("image");
        
        byte[] imageBytes = inputStraemToByteArray(filePart.getInputStream());
        
        String name = request.getParameter("name");
        
        Long id = Long.parseLong(request.getParameter("id"));
        
        String surname = request.getParameter("surname");
        
        Student s = createStudent(imageBytes,name,surname,id);
        sfl.create(s);
        
        RequestDispatcher disp = request.getRequestDispatcher("addOutcome.jsp");
        disp.forward(request, response);
    }

    private byte[] inputStraemToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        
        int bytesRead;
        byte[] data = new byte[1024];
        
        while((bytesRead = inputStream.read(data,0,data.length))!= -1)
        {
            buffer.write(data,0,bytesRead);
        }
        
        buffer.flush();
        
        return buffer.toByteArray();
    }

    private Student createStudent(byte[] imageBytes, String name, String surname, Long id) {
       Student s = new Student();
       
       Timestamp time = new Timestamp(System.currentTimeMillis());
       
       s.setDate(time);
       s.setId(id);
       s.setImage(imageBytes);
       s.setName(name);
       s.setSurname(surname);
       
       return s;
       
    }

}
