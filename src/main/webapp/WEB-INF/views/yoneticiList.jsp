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
	<div class="containerManav">
		<h2>Yonetici</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Username</th>
				<th>Password</th>
			</tr>

			<c:forEach items="${yonetici}" var="yonetici" varStatus="status">

			
				<c:url var="updateLink" value="/yonetici/update">
					<c:param name="id" value="${yonetici.id}" />
				</c:url>

			
				<c:url var="deleteLink" value="/yonetici/delete">
					<c:param name="id" value="${yonetici.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${yonetici.id}</td>
					<td>${yonetici.username}</td>
					<td>${yonetici.password}</td>
					<td>
						
						 
						 <a class="update" href="${updateLink}">Update</a> 
						 <a class="delete" href="${deleteLink}">Delete</a> 
						
					</td>
				</tr>
				
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/yonetici/new">Add Yonetici</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/yonetici/list">Home Page</a>
	</div>
</body>
</html>