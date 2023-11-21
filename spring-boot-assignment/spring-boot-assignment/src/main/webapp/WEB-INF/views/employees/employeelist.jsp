<%@page import="com.valtech.training.springbootassignment.model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of employees</h2>
<% List<EmployeeModel> em = (List<EmployeeModel>) request.getAttribute("employees"); %>
<table border="1" width="30%" height="20%">
<tr>
	<th>Employee ID</th>
	<th>Employee Name</th>
	<th>Age</th>
	<th>Experience</th>
	<th>Salary</th>
	<th>Actions</th>
</tr>
<% for(EmployeeModel e: em){
	request.setAttribute("e", e);%>
	
	<tr>
		<td>${e.employeeID}</td>
		<td>${e.employeeName}</td>
		<td>${e.age}</td>
		<td>${e.experience}</td>
		<td>${e.salary}</td>
		<td>
			<a href="delete?employeeID=<%= e.getEmployeeID() %>">Delete</a>
			<a href="edit?employeeID=<%= e.getEmployeeID() %>">Edit</a>
	</tr>
<%} %>
	<tfoot>
		<tr>
			<td colspan="6" align="right">
				<form action="new" method="get">
					<input type="submit" name="submit" value="New Employee">
				</form>
			</td>
		</tr>
	</tfoot>

</table>
</body>
</html>