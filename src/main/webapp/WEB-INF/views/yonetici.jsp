<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Yonetici-project</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<!-- <h2>Yonetici</h2> -->
<div class="container">
<div class="container1">
<h2>MANAV MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/manav/new">Add Manav</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/manav/">List Manav</a></p>
</div>

<div class="container2">
<h2>MARKET MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/market/new">Add Market</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/market/">List Market</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}">Home Page</a></p>
</div>

 <div class="container3">
<h2>SARKUTERI MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/sarkuteri/new">Add Sarkuteri</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/sarkuteri/">List Sarkuteri</a></p>
</div>

<div class="container1">
<h2>YONETİCİ MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/yonetici/new">Add Yonetici</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/yonetici">List Yonetici</a></p>
</div>   
</div>
</body>
</html>