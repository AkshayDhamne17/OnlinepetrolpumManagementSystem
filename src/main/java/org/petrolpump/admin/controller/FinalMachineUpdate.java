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
public class FinalMachineUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String btn=request.getParameter("s");
	        if(btn!=null)
	        {
	        	int mid=Integer.parseInt(request.getParameter("mid"));
	        	String machineCode=request.getParameter("mcode");
	        	MachineModel model=new	MachineModel();
	        	model.setId(mid);
	        	model.setMachineCode(machineCode);
	        	MachineService mService=new MachineServiceImpl();
	        	boolean b=mService.isUpdateMachine(model);
	        	if(b)
	        	{
	        		RequestDispatcher r =request.getRequestDispatcher("viewmachine.jsp");
	        		r.forward(request, response);
	        	}
	        	else {
	        		out.println("<h1>Machine Data Not Updated</h1>");
	        	}
	        	
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
