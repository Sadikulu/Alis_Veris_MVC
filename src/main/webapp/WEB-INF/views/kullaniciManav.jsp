<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Manav-project</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerManav">
		<h2>Manav</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>No</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
			</tr>

			<c:forEach items="${manav}" var="manav" varStatus="status">

				<!-- create an "update" link with Manav id -->
				<c:url var="sepetLink" value="/sepet/new">
					<c:param name="id" value="${manav.id}" />
				</c:url>

				<!-- create an "delete" link with Manav id 
				<c:url var="deleteLink" value="/manav/delete">
					<c:param name="id" value="${manav.id}" />
				</c:url> -->

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${manav.id}</td>
					<td>${manav.urunAdi}</td>
					<td>${manav.urunFiyati}</td>
					<td> 
						 
						 <a class="update" href="${sepetLink}">Sepete Ekle</a> 
					</td>
				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/sepet">Sepet</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/kullanici">Home Page</a>
	</div>
</body>
</html>