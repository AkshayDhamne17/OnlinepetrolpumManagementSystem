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
  <form class="formarea" name="frm" action="addemployee" method="post">
  
  <div class="form-group">
    <label for="exampleInputEmail1">Employee Name</label>
    <input type="text" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Aditya">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Employee Email</label>
    <input type="text" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Aditya@123">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Employee Contact</label>
    <input type="text" class="form-control" name="contact" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="1234567891">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Employee Address</label>
    <input type="text" class="form-control" name="address" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mumbai">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Employee Salary</label>
    <input type="text" class="form-control" name="sal" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="30000">
  </div>
  
    <br/><br/>
  <button type="submit" class="btn btn-primary">Add New Employee</button>
</form>     
        </div>
    </div>
</div>
</body>
</html>