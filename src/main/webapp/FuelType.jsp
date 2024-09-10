<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
         
         <form class="formarea" name="frm" action="fueltype" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Fuel Type</label>
    <br/><br/>
    <input type="text" class="form-control" name="type" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Fuel Type">
  </div>
  
    <br/><br/>
  <button type="submit" class="btn btn-primary">Add New Fuel Type</button>
</form>
         
        </div>
    </div>
</div>

</body>
</html>