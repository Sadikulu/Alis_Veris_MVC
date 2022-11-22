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
				<th>No</th>
				<th>Urun Adi</th>
				<th>Urun Fiyati</th>
			</tr>

			<c:forEach items="${sarkuteri}" var="sarkuteri" varStatus="status">
                
                <c:url var="sepetLink" value="sepet/new">
					<c:param name="id" value="${sarkuteri.id}" />
				</c:url>
				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${sarkuteri.id}</td>
					<td>${sarkuteri.urunAdi}</td>
					<td>${sarkuteri.urunFiyati}</td>
					<td>
					<a class="post" href="${sepetLink}">Sepete Ekle</a>${sakuteri.id}
					<!-- <a class="post" href="${pageContext.request.contextPath}/sepet/new">Sepete Ekle</a>--> 
					</td>
				</tr>
				
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/sepet">Sepet</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/kullanici">Home Page</a>
	</div>
</body>
</html>