<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Kullanici</title>
<link rel="stylesheet" href="/manav-mvc/resources/css/style.css">
</head>
<body>
	<div class="containerKullanici">
		<div align="center">
			<h2>Kayit Paneli</h2>
			<table>
				<form:form modelAttribute="yonetici" action="saveYonetici" method="post">
					 <form:hidden path="id" />
					<tr>
						<td class="studentprop">Username:</td>
						<td><form:input path="username" size="30" /></td>
						<td><form:errors path="username" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop">Password:</td>
						<td><form:password path="password" size="30" /></td>
						<td><form:errors path="password" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Sign In</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>