<%-- 
    Document   : login
    Created on : 30 dic 2022, 9:25:33
    Author     : danib
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css">
    <form action="register.do" method="POST">
        <h1>Employer Log in</h1>
        <div class="inset">
            <p>
              <label for="email">EMAIL ADDRESS</label>
              <input type="text" name="email" id="email">
            </p>
            <p>
              <label for="password">PASSWORD</label>
              <input type="password" name="password">
            </p>
        </div>
        <p class="p-container">
            <input type="button" name="path" value="Go back!" onclick="history.back()">
            <input type="submit" value="Log in">
        </p>
    </form>
</html>