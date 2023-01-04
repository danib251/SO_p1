<%-- 
    Document   : purchaseInfo
    Created on : 2 ene 2023, 11:43:04
    Author     : danib
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="resources/css/purchaseInfo.css">
    <div class="text">
        <h1>Purchase Completed</h1>
        <h2>ID: ${purchase.id}</h2>
        <h2>Quantity: ${purchase.quantity}</h2>
        <h2>Price: ${purchase.value} eur.</h2>
        <h2>Time: ${purchase.time}</h2>
        <p class="p-container">
           
             <a href="/SOBASE/ListCryptoMain.do"><button  type="button">Go back</button> </a>
        </p>
    </div>
</html>
