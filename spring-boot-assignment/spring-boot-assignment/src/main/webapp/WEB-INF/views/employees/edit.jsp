<%@page import="com.valtech.training.springbootassignment.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% EmployeeModel em = (EmployeeModel)request.getAttribute("employees");  %>
<form method="post" action="save?employeeID=<%= em.getEmployeeID() %>">
<table>
	<tr>
		<td>Employee Id</td>
		<td><input type="text" disabled="disabled" name="employeeID" value="<%= em.getEmployeeID() %>"/></td>
	</tr>
	<tr>
		<td>Employee Name</td>
		<td><input type="text" name="employeeName" value="<%= em.getEmployeeName() %>"/></td>
	</tr>
	<tr>
		<td>Age</td>
		<td><input type="text" name="age" value="<%= em.getAge() %>"/></td>
	</tr>
	<tr>
		<td>Experience</td>
		<td><input type="text" name="experience" value="<%= em.getExperience() %>"/></td>
	</tr>
	<tr>
		<td>Salary</td>
		<td><input type="text" name="salary" value="<%= em.getSalary() %>"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" name="submit" value="Create"/>
			<input type="submit" name="cancel" value="Cancel"/>
		</td>
	</tr>
	
</table>
</form>
</body>
</html>