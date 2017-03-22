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

<h3 class="text-center"> Manage Supplier </h3>
<br>

<div class="contanier-solid text-center">
<p> You Create a New Supplier</p>
<from action="#" method="post">
<input type="text" name="id" placeholder="SupplierId">
<input type="text" name="name" placeholder="SupplierName">
<input type="text" name="Address" placeholder="SupplierAddress">
<input type="submit" value="Create">
</from>
<hr>

<br>
</div>

<!-- ================================= End of create suppplier ======================== -->

<div class="container">
<h3>Details Of Supplier</h3>
<P> list of Supplier</P>

<table class="table">
<thead>
<tr>
<th>ID</th>
<th>NAME</th>
<th>ADDRESS</th>
<th>ACTION</th>
</tr>
</thead>
<tbody>

<c:forEach var="supplier" items="${supplierList}">
<tr>
<td>${supplier.id}</td>
<td>${supplier.name}</td>
<td>${supplier.address}</td>
</tr>
 </c:forEach>
</tbody>

</table>
</div>

</body></html>