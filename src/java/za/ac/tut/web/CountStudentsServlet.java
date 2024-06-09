/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.StudentFacadeLocal;

/**
 *
 * @author Jeanette
 */
public class CountStudentsServlet extends HttpServlet {

   
   @EJB
private StudentFacadeLocal sfl;
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cnt = sfl.count();
        
        request.setAttribute("cnt", cnt);
        
          RequestDispatcher disp = request.getRequestDispatcher("countStudentsOutcome.jsp");
        disp.forward(request, response);
    }
}