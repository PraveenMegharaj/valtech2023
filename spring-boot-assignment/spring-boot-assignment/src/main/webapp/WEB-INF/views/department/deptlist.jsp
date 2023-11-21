<%@page import="java.util.List"%>
<%@page import="com.valtech.training.springbootassignment.model.DepartmentModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department</title>
</head>
<body>
<h2>Department List</h2>
<%List<DepartmentModel> dm = (List<DepartmentModel>)request.getAttribute("dept"); %>
<table border="1" width="30%" height="20%">
<tr>
	<th>Department ID</th>
	<th>Department Name</th>
	<th>Department Location</th>
	<th>Actions</th>
</tr>
<% for(DepartmentModel d: dm){
	request.setAttribute("d", d);%>
	
	<tr>
		<td>${d.deptId}</td>
		<td>${d.deptName}</td>
		<td>${d.deptLocation}</td>
		<td>
			<a href="delete?deptId=<%= d.getDeptId() %>">Delete</a>
			<a href="edit?deptId=<%= d.getDeptId() %>">Edit</a>
	</tr>
<%} %>
	<tfoot>
		<tr>
			<td colspan="6" align="right">
				<form action="new" method="get">
					<input type="submit" name="submit" value="New Department">
				</form>
			</td>
		</tr>
	</tfoot>

</table>
</body>
</html>