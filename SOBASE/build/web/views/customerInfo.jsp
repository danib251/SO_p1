<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Success - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" type="text/css" href="resources/css/customerInfo.css">
</head>

<div class="container h-100">
  <div class="row h-100 align-items-center justify-content-center">
    <div class="main">
      <div class="info">
        <img src="http://i63.tinypic.com/2m6vae8.jpg" class="prof rounded-circle img-fluid" />
        <h1>${user.name}</h1>
        <hr>
      </div>
      <div class="body">
       <ul class="fa-ul">
         <li><span class="fa-li"><i class="fas fa-heart"></i></span>${user.credentials.username}</li>
         <li><span class="fa-li"><i class="fas fa-heart"></i></span>${user.phone}</li>
         <li><span class="fa-li"><i class="fas fa-heart"></i></span>Lover of cats</li
        </ul>
      </div>
      <div class="footer">
        <a href="#"><i class="fab fa-facebook-square"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-tumblr"></i></a>
      </div>
    </div>
  </div>
</div>
</html>