package org.petrolpump.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.petrolpump.admin.model.FuelTypeModel;
import org.petrolpump.admin.service.*;
public class FuelTypeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  String fueltype=request.getParameter("type");
		  FuelTypeModel model=new FuelTypeModel();
		  model.setName(fueltype);
		  FuelService fService = new FuelTypeServiceImpl();
		  boolean b=fService.isAddFuelType(model);
		  if(b)
		  {
			  RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
			  r.include(request, response);
			  out.println("<center>Fuel Type Added Successfully.........</center>");
		  }
		  else {
			  RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
			  r.include(request, response);
			  out.println("<center>Some Problem Is There.........</center>");
		  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
