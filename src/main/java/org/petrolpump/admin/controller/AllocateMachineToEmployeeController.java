package org.petrolpump.admin.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.petrolpump.admin.service.*;
import java.util.*;
public class AllocateMachineToEmployeeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r =request.getRequestDispatcher("admindashboard.jsp");
        r.include(request, response);
        
        MachineService mService=new MachineServiceImpl();
        List<Object[]> list=mService.getallMachines();
        LinkedHashMap <Integer,String> hs=new LinkedHashMap<Integer,String>();
        for(Object obj[]:list)
        {
        	hs.put((Integer)obj[3],obj[0].toString());
        }
        int empId=Integer.parseInt(request.getParameter("empid"));
        String empName=request.getParameter("empName");
        
        out.println("<h1> Hey "+empName+" we are going to Allocate Machine</h1>");
        out.println("<div class='col py-3'>");
        out.println("<form class='formarea' name='frm' action='finalmachineallocate' method='post'>");
        out.println("<input type='hidden' name='empid' value='"+empId+"'>");
        out.println("<select name='mid' class='control'>");
        out.println("<option>Select Machine</option>");
        Set<Map.Entry<Integer,String>> s=hs.entrySet();
        for(Map.Entry<Integer,String> m:s)
        {
        	out.println("<option value='"+m.getKey()+"'>");
        	out.println(m.getValue());
        	out.println("</option>");
        	
        }
        out.println("</select>");
        out.println("<input type='time' name='startTime' value='' class='control'/><br/><br/>");
        out.println("<input type='time' name='endTime' value='' class='control'/><br/><br/>");
        out.println("<input type='date' name='allDate' value='' class='control'/><br/><br/>");
        out.println("<input type='submit' name='s' value='Allocate Machine To Employee' class='control'>");
        out.println("</div></div></div>");
        ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
