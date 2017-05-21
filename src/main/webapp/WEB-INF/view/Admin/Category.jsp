<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2> <center>	Manage Categories </center> </h2>
<hr>




<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Create New Category</h3>
					</div>
					<div class="panel-body">






<div class="text-center">
<p class="text-success"> Fill the details</p>
<form action="manage_category_create" method="post">
<input type="text" name="id" placeholder="CategoryId"> 
<input type="text" name="name" placeholder="CategoryName"> 
<input type="text" name="description"  placeholder="CategoryDescription"> 
<br>
<input type="submit" value="Create">
</form>
</div>







</div>
</div>
</div>
</div>
</div>







<br>
<h4> Details Of Category </h4>
<center>
	<table class="table table-hover">


		<thead>
			<tr>
				<td>ID</td>  	<td>Name</td>	<td>Description</td> <td>Action</td>
		</tr>
		</thead>

		<c:forEach var="category" items="${categoryList}">
			<tr>

				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.description}</td>
				<td><a href="<c:url value='/manage_category_edit/${category.id}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_category_delete/${category.id}' />">Delete</a></td>

			</tr>
		</c:forEach>

	</table>
</center>
</body>
</html>