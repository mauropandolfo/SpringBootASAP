<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>${titulo }</title>
	</head>
	<body>
		<h1>PROFESOR ${profesor}</h1>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Codigo</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Respositorio</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
				<c:forEach items="${alumnos}" var="alumno">
					<tr>
						<td><c:out value="${alumno.getCodigo()}"/></td>
						<td><c:out value="${alumno.getNombre()}"/></td>
						<td><c:out value="${alumno.getApellido()}"/></td>
						<td><c:out value="${alumno.getLinkArepositorio()}"/></td>
					</tr>
				</c:forEach>
		    </tr>
		  </tbody>
		</table>
	</body>
</html>