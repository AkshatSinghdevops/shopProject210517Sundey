<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/mystyle.css">
<link rel="stylesheet" href="resource/img/im.jpg">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>

<!-- - -->
<div class="container-fluid top_bar" style="background:#f26522; padding:5px;">
<div class="container top_bar">
<div class="row">
<div class="col-sm-6">
<a href="#">Shopping_Cart</a>
   <a href="#" class="social_icon"><i class="fa fa-facebook" style="font-size:20px; color:#fff;"></i></a>
   <a href="#" class="social_icon"><i class="fa fa-twitter"  style="font-size:20px; color:#fff;"></i></a>
   <a href="#" class="social_icon"><i class="fa fa-youtube"  style="font-size:20px; color:#fff;"></i></a>
   <a href="#" class="social_icon"><i class="fa fa-google"   style="font-size:20px; color:#fff;"></i></a>

</div><!--  end of colunm 6  -->

<div class="col-sm-6 text-right contact_info">
<span class="glyphicon glyphicon-envelope">singh.akshat960@gmail.com</span>
   <span class="glyphicon glyphicon-earphone">+91-8224-9984-73</span>

</div><!--  end of colunm 6 Part 2 -->

</div>
</div>
</div>


<nav class="navbar-default ">
<div class="container top_bar">
<div class="row">


<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <div class = "collapse navbar-collapse" id ="navbar">
          
 
        
<div class="text-center ">
<center>${Entry }</center>


<div class="text-success text-center">${msg}${message} </div>
${role}
<center class="text-danger">${successMessage}</center>

${errorMessage}


</div>

<div class="text-right" style="margin:10px;">

${loginMessage}
</div>
</div>


</div>
</div></nav>
<!-- -----------------------------------------=================== -->
<div class ="container-fluid  second_bar" style="background:#0000ff; solid; padding:20px;" >
<div class="container">

<!-- ----------- -->
   


 <ul class="nav navbar-nav navbar-right" >
 <c:if test="${isUserAdmin==false}">
        <button type="button" class="btn btn-success dropdown-toggle"  style="margin:8px">
       <li><a href="Mycart" style="color:#ffff00" class="social_icon" ><i class="fa fa-shopping-cart" aria-hidden="true" style="color:#fff;">My_Cart</i></a></li>
       </button></c:if>
       
       
       <c:if test="${empty loginMessage}">
      <li><a href="Registration" style=" color:#fff;"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="Login" style=" color:#fff;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${not empty loginMessage }"><li><a href="logout" style=" color:#fff;">Logout</a></li></c:if>
    </ul>


<!-- ---------- -->


<div class="row">
 <div class="col-sm-12">
  <nav class="navbar-default"  style="margin:4px;">
 <div class="navbar-header">
 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#Tnavbar">
 <span class="icon-bar"></span>
 <span class="icon-bar"></span>
 <span class="icon-bar"></span>
 <span class="icon-bar"></span>
 </button>
 </div>
 <div id="Tnavbar" class="navbar-collapse collapse">
  <ul class="nav navbar-nav ">
  <li><a href="index">Home</a></li>
  
  <li> <a href="#" >About-us</a></li>
  <li> <a href="Contact" >Contact</a></li>
  </ul>
 <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form></div>
  
    <!-- ======================================================================================================================= -->
    <jsp:include page="Menu.jsp"></jsp:include>
    <!-- ======================================================================================================================== -->
    
 </div>
 
 <div class="btn-group">
    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">Action <span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li class="divider"></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>

 
</div>
</div>
</div>
</nav>
<!-- ================================================================ -->







<c:if test="${isUserAdmin==true }"><jsp:include page="Admin/AdminHome.jsp"></jsp:include></c:if>


<!--  -->
<c:if test="${empty loginMessage}">
</c:if>
<!--  -->

<jsp:include page="Carousel.jsp"></jsp:include>




<c:if test="${isUsermycart==true }"><jsp:include page="Mycart.jsp"></jsp:include></c:if>
<c:if test="${isUserAdmin==true }"><jsp:include page="Admin/AdminHome.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedContact==true }"><jsp:include page="Contact.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedLogin==true}"><jsp:include page="Login.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedRegistration==true}"><jsp:include page="Registration.jsp"></jsp:include></c:if>
<c:if test="${not empty errorMessage }"><jsp:include page="Login.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedMenu==true }"><jsp:include page="Menu.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedCategories==true}"><jsp:include page="Admin/Category.jsp"></jsp:include></c:if>
<c:if test="${ClickedSupplier==true}"><jsp:include page="Admin/Supplier.jsp"></jsp:include></c:if>
<c:if test="${isUserClickedProduct==true}"><jsp:include page="Admin/Product.jsp"></jsp:include></c:if>







<!--  
<c:if test="${not empty loginMessage}"> 
<a href="logout">Logout </a><br>
</c:if>

<c:if test="${not empty errorMessage}"> 
<a href="Login.jsp">login </a><br>

</c:if>
-->





</body>
</html>
