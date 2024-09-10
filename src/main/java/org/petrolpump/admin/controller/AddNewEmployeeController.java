package org.petrolpump.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.petrolpump.admin.model.*;
import org.petrolpump.admin.service.*;
public class AddNewEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		int sal=Integer.parseInt(request.getParameter("sal"));
		
		EmployeeModel empModel=new EmployeeModel();
		empModel.setName(name);
		empModel.setEmail(email);
		empModel.setContact(contact);
		empModel.setAddress(address);
		empModel.setSal(sal);
		
		EmployeeService empService= new EmployeeServiceImpl();
		
		boolean b=empService.isAddNewEmployee(empModel);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
			r.include(request, response);
			out.println("<h1>Employee Added Successfully</h1>");
		}
		else {
			RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
			r.include(request, response);
			out.println("<h1>Employee Not Added Successfully</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
