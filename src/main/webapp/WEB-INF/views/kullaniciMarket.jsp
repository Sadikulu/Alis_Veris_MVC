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
				<th>No</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
			</tr>

			<c:forEach items="${market}" var="market" varStatus="status">
				<c:url var="sepetLink" value="sepet/new">
					<c:param name="id" value="${market.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${market.id}</td>
					<td>${market.urunAdi}</td>
					<td>${market.urunFiyati}</td>
					
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