<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h3 class="text-danger"> Welcome To Admin Page </h3>
<hr>

<nav class="navbar-inverse">
<div class="container">
<div class="row">



<ul class="nav navbar-nav">

<li><a href="ManageCategory">ManageCategory</a></li>
<li><a href="ManageProduct">ManageProduct</a></li>
<li><a href="ManageSupplier">ManageSupplier</a></li>
<li><a href="index">Home</a></li>

</ul>

</div></div></nav>















<c:if test="${isUserClickedCategories==true}"><jsp:include page="Category.jsp"></jsp:include></c:if>
<c:if test="${ClickedSupplier==true}"><jsp:include page="Supplier.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedProduct==true}"><jsp:include page="Product.jsp"></jsp:include></c:if>
<c:if test="${isAdminClickedHome==true}"><jsp:include page="../index.jsp"></jsp:include>     </c:if>






</body>
</html>