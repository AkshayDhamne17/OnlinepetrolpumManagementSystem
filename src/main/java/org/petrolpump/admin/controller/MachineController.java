package org.petrolpump.admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.petrolpump.admin.model.MachineModel;
import org.petrolpump.admin.service.MachineService;
import org.petrolpump.admin.service.MachineServiceImpl;

public class MachineController extends HttpServlet {

	 MachineService machineService=new  MachineServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
         String machineCode=request.getParameter("machineCode");	
         String ftypeId[]=request.getParameterValues("ftype");
         String capArray[]=request.getParameterValues("capacity");
         MachineModel model=new MachineModel();
         model.setMachineCode(machineCode);
         boolean b= machineService.isAddNewMachine(model,ftypeId,capArray);
         if(b)
         {
        	 out.println("<h1>Machine Added SucessFully...........</h1>");
         }
         else {
        	 out.println("<h1>Machine Not Added SuccessFully...........</h1>");
         }
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
