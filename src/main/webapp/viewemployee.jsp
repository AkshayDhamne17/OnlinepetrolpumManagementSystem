<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="org.petrolpump.admin.service.*,java.util.*,org.petrolpump.admin.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!MachineService machineService = new MachineServiceImpl();%>

	<%@include file="admindashboard.jsp"%>

	<div class="col py-3">
		<br />
		<br />
		<br />
		<br />

		<h1>Machine Details</h1>
		<table class="table">

			<thead>
				<tr>
					<th scope="col">Sr.No</th>
					<th scope="col">Employee Name</th>
					<th scope="col">Contact</th>
					<th scope="col">Allocate Machine</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>

		<%
		EmployeeService  empService=new EmployeeServiceImpl();
		List<EmployeeModel> list=empService.getAllEmployees();
		int count=0;
		for(EmployeeModel eModel:list)
		{
		%>
		<tr>
		<td><%= ++count%></td>
		<td><%=eModel.getName()%></td>
		<td><%=eModel.getContact()%></td>
		<td><a href='allocatemachine?empid=<%=eModel.getId()%>&empName=<%=eModel.getName()%>'>Allocate Machine</a></td>
		<td><a href=''>Delete</a></td>
		<td><a href=''>Update</a></td>
		
		</tr>
		<% 
		}
		%>
		
		
		

			</tbody>
		</table>


	</div>
	</div>
	</div>


</body>
</html>