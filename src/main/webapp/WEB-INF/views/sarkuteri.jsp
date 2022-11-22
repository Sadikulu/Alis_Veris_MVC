<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Sarkuteri-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerSarkuteri">
		<h2>Sarkuteri</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
				<th>CreateDate</th>
			</tr>

			<c:forEach items="${sarkuteri}" var="sarkuteri" varStatus="status">

				<!-- create an "update" link with Sarkuteri id -->
				<c:url var="updateLink" value="/sarkuteri/update">
					<c:param name="id" value="${sarkuteri.id}" />
				</c:url>

				<!-- create an "delete" link with Sarkuteri id -->
				<c:url var="deleteLink" value="/sarkuteri/delete">
					<c:param name="id" value="${sarkuteri.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${sarkuteri.id}</td>
					<td>${sarkuteri.urunAdi}</td>
					<td>${sarkuteri.urunFiyati}</td>
					<td>${sarkuteri.createDate}</td>
					<td>
						<!-- show the links --> 
						 
						<a class="update" href="${updateLink}">Update</a> 
						<a class="delete" href="${deleteLink}"> Delete</a>
					</td>
				</tr>
				
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/sarkuteri/new">Add Sarkuteri</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/yonetici">Home Page</a>
	</div>
</body>
</html>