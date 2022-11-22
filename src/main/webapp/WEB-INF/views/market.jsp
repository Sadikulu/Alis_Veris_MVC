<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Market-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerMarket">
		<h2>Market</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
				<th>CreateDate</th>
			</tr>

			<c:forEach items="${market}" var="market" varStatus="status">

				<!-- create an "update" link with Market id -->
				<c:url var="updateLink" value="/market/update">
					<c:param name="id" value="${market.id}" />
				</c:url>

				<!-- create an "delete" link with Market id -->
				<c:url var="deleteLink" value="/market/delete">
					<c:param name="id" value="${market.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${market.id}</td>
					<td>${market.urunAdi}</td>
					<td>${market.urunFiyati}</td>
					<td>${market.createDate}</td>
					
					<td>
						<!-- show the links -->
						<a class="delete" href="${deleteLink}"> Delete</a> 
						<a class="update" href="${updateLink}">Update</a> 
					</td>
				</tr>
				
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/market/new">Add Market</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/yonetici">Home Page</a>
	</div>
</body>
</html>