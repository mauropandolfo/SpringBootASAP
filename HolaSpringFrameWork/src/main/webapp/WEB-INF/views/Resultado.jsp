<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Resultado!</title>
	</head>
	<body>
		<h1>El resultado del juego es: </h1>
		<p> El jugador eligio:</p>
		<p>${jugador}</p>
		<br/>
		<p>la computadora eligio:</p>
		<p>${computadora}</p>
		
		${resultado}
	</body>
</html>