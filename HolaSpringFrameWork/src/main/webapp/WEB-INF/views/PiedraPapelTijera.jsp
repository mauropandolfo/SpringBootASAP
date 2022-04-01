<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Juego de piedra papel tijera lagarto spock</title>
	</head>
	<body>
		<form action="http://localhost:8081/HolaSpringFrameWork/resolverJuego" method="GET">
			<select name="selOpcion">
				<c:forEach items="${opciones}" var="opcion">
						<option value="${opcion.getNumero()}">${opcion}</option>
				</c:forEach>
			</select>	
			<button type="submit"> Jugar!</button>
		</form>
	</body>
</html>