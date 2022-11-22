<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Manav</title>
<link rel="stylesheet" href="/manav-mvc/resources/css/style.css">
</head>
<body>
	<div class="containerManav">
		<div align="center">
			<h2>Add / Update Sepet</h2>
			<table>
				<form:form modelAttribute="sepet" action="saveSepet" method="post">
					 <form:hidden path="id" />
					<tr>
						<td class="studentprop">Urun Adi:</td>
						<td><form:input path="urunAdi" size="30" /></td>
						<td><form:errors path="urunAdi" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop">Urun Fiyati:</td>
						<td><form:input path="urunFiyati" size="30" /></td>
						<td><form:errors path="urunFiyati" class="error" /></td>
					</tr>
					
					<tr>
						<td class="studentprop">Adet:</td>
						<td><form:input path="adet" size="30" /></td>
						<td><form:errors path="adet" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>