<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Resultado!</title>
	</head>
	<body>
		<div class="container col-md-4">
			<h1>El resultado del juego es: </h1>
			<p> El jugador eligio:</p>
			<p>${jugador}</p>
			<br/>
			<p>la computadora eligio:</p>
			<p>${computadora}</p>
			${resultado}
			<br/>
			<br/>
			<a href="./juego"><button type="button" class="btn btn-success">Volver a jugar!</button></a>		
		</div>
	</body>
</html>