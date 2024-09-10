package org.petrolpump.admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.petrolpump.admin.service.*;
public class FinalMachineAllocateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int empId=Integer.parseInt(request.getParameter("empid"));
		int mid=Integer.parseInt(request.getParameter("mid"));
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		String date=request.getParameter("allDate");
		EmployeeService empService=new EmployeeServiceImpl();
		boolean b=empService.allocateMachine(empId,mid,startTime,endTime,date);
		if(b)
		{
			out.println("<h1>Machine Allocated Successfully.......</h1>");
		}
		else {
			out.println("<h1>Machine Not Allocated Successfully.......</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
