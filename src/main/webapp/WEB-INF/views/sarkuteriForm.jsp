<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Sarkuteri</title>
<link rel="stylesheet" href="/manav-mvc/resources/css/style.css">
</head>
<body>
	<div class="containerSarkuteri">
		<div align="center">
			<h2>Add / Update Sarkuteri</h2>
			<table>
				<form:form modelAttribute="sarkuteri" action="saveSarkuteri" method="post">
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
						<td class="studentprop">Stok Adedi:</td>
						<td><form:input path="stokAdedi" size="30" /></td>
						<td><form:errors path="stokAdedi" class="error" /></td>
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