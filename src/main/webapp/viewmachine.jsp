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
					<th scope="col">Machine Code</th>
					<th scope="col">Fuel Type</th>
					<th scope="col">Capacity</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>

				<%
				List<Object[]> list = machineService.getallMachines();
				int count = 0;
				for (Object obj[]:list){
				%>
				<tr>
					<th scope="row"><%=++count%></th>
					<td><%=obj[0]%></td>
					<td><%=obj[1]%></td>
					<td><%=obj[2]%></td>
					<td><a href='del?machineid=<%=(int)obj[3]%>'>DELETE</a></td>
					<td><a
						href='updmachine?mid=<%=(int)obj[3]%>&mcode=<%=obj[0].toString()%>'>UPDATE</a></td>
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