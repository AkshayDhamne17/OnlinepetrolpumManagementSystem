package org.petrolpump.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import org.petrolpump.admin.service.*;
public class DeleteMachineController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int mid=Integer.parseInt(request.getParameter("machineid"));
		MachineService mService = new MachineServiceImpl();
		boolean b=mService.isDeleteMachineById(mid);
		if(b)
			{
			RequestDispatcher r=request.getRequestDispatcher("viewmachine.jsp");
			r.forward(request, response);
			}
		else{
			out.println("<h1>Some Problem Is There</h1>");
		};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
