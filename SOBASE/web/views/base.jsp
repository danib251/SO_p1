<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="cat.urv.deim.sob.model.User" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
    <!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/base.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Success - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
   <body>
        
        <div class="topnav">
            <a class="active" href="/SOBASE/ListCryptoMain.do">Home</a>
            
            <%@ page session="false" %> 
   
            <%
                User user = new User();
                HttpSession session=request.getSession(false);  
                user = (User) session.getAttribute("user");
                request.setAttribute("user", user); 
            %>
            
            <c:if test="${user==null}">
                <a href="<c:url value="/login.do"/>">Login </a> 
            </c:if>
            <c:if test="${user!=null}">
                <a href="<c:url value="/customerInfo.do"/>">Hi, ${user.name}</a>
            </c:if>  
     
        
        </div>
    </body>