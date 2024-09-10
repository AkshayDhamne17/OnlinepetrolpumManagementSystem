package org.petrolpump.employee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import org.petrolpump.admin.service.*;
public class EmployeeValidateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();
      String email=request.getParameter("email");
      String contact=request.getParameter("contact");
      EmployeeService empService=new EmployeeServiceImpl();
      int result=empService.verifyEmployee(email, contact);
      if(result!=0)
      {
    	 HttpSession session=request.getSession(true);
    	 session.setAttribute("employeeId",result);
    	   RequestDispatcher r=request.getRequestDispatcher("employeedashboard.jsp");
    	   r.forward(request, response);
      }
      else {
    	  out.println("Invalid username or password");
      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
