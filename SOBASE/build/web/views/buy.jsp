<%-- 
    Document   : buy
    Created on : 31 dic 2022, 12:07:42
    Author     : danib
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
<!DOCTYPE html>
<html>
    <form action="makePurchase.do">
        <h1>${crypto.name}</h1>
        <h2 name="id" id="id">Price: ${crypto.value} eur.</h2>
        <div class="inset">
            <p>
              <label for="Quantity">Quantity</label>
              <input type="text" name="Quantity" id="Quantity">
            </p>
            
        </div>
        <p class="p-container">
            <input type="submit" value="BUY">
        </p>
    </form>
</html>
