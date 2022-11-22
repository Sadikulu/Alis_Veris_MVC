<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Kullanici-project</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
<div class="container1">
<h2>MANAV MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/kullanici/manav/">List Manav</a></p>
</div>

<div class="container2">
<h2>MARKET MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/kullanici/market/">List Market</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}">Home Page</a></p>
</div>

 <div class="container3">
<h2>SARKUTERI MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/kullanici/sarkuteri/">List Sarkuteri</a></p>
</div>   
</div>
</body>
</html>