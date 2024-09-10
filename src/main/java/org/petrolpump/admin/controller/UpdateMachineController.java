package org.petrolpump.admin.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.petrolpump.admin.model.MachineModel;

public class UpdateMachineController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
        int mid=Integer.parseInt(request.getParameter("mid"));
        String machineCode=request.getParameter("mcode");
        RequestDispatcher r=request.getRequestDispatcher("admindashboard.jsp");
        r.include(request, response);
        
        out.println(" <div class='col py-3'>");
        out.println("<form class='formarea' name='frm' action='finalmachineupdate' method='post'>");
        out.println("<input type='hidden' name='mid' value='"+mid+"' class='control'/><br/><br/>");
        out.println("<input type='text' name='mcode' value='"+machineCode+"' class='control'/><br/><br/>");
        out.println("<input type='submit' name='s' value='Update Machine Code' class='control'>");
        out.println("</div></div></div>");
        
       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
