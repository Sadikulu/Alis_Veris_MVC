<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Sepet-project</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerManav">
		<h2>Sepet</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>No</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
				<th>Adet</th>
				<!-- CreateDate</th> --><th>
			</tr>

			<c:forEach items="${sepet}" var="sepet" varStatus="status">

				
				<c:url var="updateLink" value="/sepet/update">
					<c:param name="id" value="${sepet.id}" />
				</c:url>

				
				<c:url var="deleteLink" value="/sepet/delete">
					<c:param name="id" value="${sepet.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${sepet.id}</td>
					<td>${sepet.urunAdi}</td>
					<td>${sepet.urunFiyati}</td>
					<td>${sepet.adet}</td>
					<td>
						<a class="update" href="${updateLink}">Update</a> 
						<a class="delete" href="${pageContext.request.contextPath}/sepet/delete/${sepet.id}">Delete</a>
						
					</td>
				</tr>
				
			</c:forEach>
		</table>
		<!-- <p><a class="normal" href="${pageContext.request.contextPath}/kullanici/sepet/new">Add Sepet</a> -->
		<p><a class="normal" href="${pageContext.request.contextPath}/kullanici">Home Page</a>
	</div>
</body>
</html>