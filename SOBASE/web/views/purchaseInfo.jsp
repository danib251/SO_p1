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
   
    
        <h1>purchase completed</h1>
        <h2>${purchase.value}</h2>
        
        <p class="p-container">
           
             <a href="/SOBASE/ListCryptoMain.do"><button  type="button">Go back</button> </a>
        </p>
  
</html>
