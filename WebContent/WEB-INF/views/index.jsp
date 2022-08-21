<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
<style type="text/css" media="screen">
#custom-button {
	padding: 5px;
	color: white;
	background: #009578;
	border: 1px solid #000;
	border-radius: 5px;
	cursor: pointer;
	background: #009578;
}

#custom-button: hover {
	background-color: #00b28f;
}

#custom-text {
	margin-left: 10px;
	font-family: sans-serif;
	color: #aaa;
}
</style>
</head>
<body>
	<script type="text/javascript">
	const realFileBtn = document.getElementById("real-file");
	const customBtn = document.getElementById("custom-button");
	const customTxt = document.getElementById("custom-text");
    </script>
	<div align="center">
		<h2>Customer Manager</h2>
		<input type="file" id="real-file" hidden="hidden">
		<button type="button" id="custom-button">CHOOSE A FILE</button>
		<span id="custom-text">No file chose, yet.</span>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="new">New Customer</a>
		</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Contact First Name</th>
				<th>Address Line 1</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listCustomer}" var="customer">
				<tr>
					<td>${customer.customerNumber}</td>
					<td>${customer.customerName}</td>
					<td>${customer.contactFirstName}</td>
					<td>${customer.addressLine1}</td>
					<td><a href="edit?id=${customer.customerNumber}">Edit</a>
						&nbsp;&nbsp;&nbsp; <a href="delete?id=${customer.customerNumber}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>