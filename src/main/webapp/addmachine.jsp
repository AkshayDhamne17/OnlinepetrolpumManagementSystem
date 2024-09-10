<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="org.petrolpump.admin.model.*,org.petrolpump.admin.service.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="CSS/adminstyle.css" rel="stylesheet"/>
</head>
<body>

<%@include file="admindashboard.jsp" %>

 <div class="col py-3">
         
         <form class="formarea" name="frm" action="newmachine" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Machine Code</label>
    <br/><br/>
    <input type="text" class="form-control" name="machineCode" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Machine Code">
    <br/><br/>
    
    <table>
    
    <%
           FuelService fService =new FuelTypeServiceImpl();
    		List<FuelTypeModel> list=fService.getAllFuelTypes();
    		for(FuelTypeModel m:list)
    		{
    	   %>
    	   <tr>
    	   <td><input type='checkbox' name='ftype' value='<%=m.getId()%>'/>&nbsp;&nbsp;<%=m.getName()%></td>
    	   <td align='right'>  <input type='text' name='capacity' value=''> </td>
    	   </tr>
    	   <% 
    		}
    		
    %>
    
    </table>
    
  </div>
    <br/><br/>
  <button type="submit" class="btn btn-primary">Add New Machine</button>
</form>
         
        </div>
    </div>
</div>

</body>
</html>