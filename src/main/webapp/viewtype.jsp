<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="org.petrolpump.admin.model.*,org.petrolpump.admin.service.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="admindashboard.jsp" %>

	<div class="col py-3">
		<br />
		<br />
		<br />
		<br />
		
		<h1>Fuel Types</h1>
		<table class="table">
		<tr>
	
		<th scope="col">TypeId</th>
		<th scope="col">TypeName</th>
		</tr>
		<%
		 FuelService  fService = new FuelTypeServiceImpl();
		List<FuelTypeModel> list=fService.getAllFuelTypes();
		int count=0;
		for(FuelTypeModel m:list)
		{
	    %>	
	
	     <td><%=m.getId()%></td>
	     <td><%=m.getName()%></td>
	     </tr>
	    <% 
		}
		%>
		</table>
		
	</div>
	</div>
	</div>
		

</body>
</html>