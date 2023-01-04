<%-- 
    Document   : buy
    Created on : 31 dic 2022, 12:07:42
    Author     : danib
--%>

<jsp:directive.include file = "base.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/buy.css">
    </head>
    <body>
        
        <form action="makePurchase.do">
            
            <div class="inset">
                <h1>${crypto.name}</h1>
                <h2 name="id" id="id">Price: ${crypto.value} eur.</h2>
                <div class="info">
                    <p>
                      <label for="Quantity">Quantity</label>
                      <input type="text" name="Quantity" id="Quantity">
                    </p> 
                    <p class="p-container">
                        <input type="submit" value="BUY">
                    </p>
                </div>
            </div>
        </form>
    </body>
</html>
