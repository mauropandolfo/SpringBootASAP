<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>Juego de piedra papel tijera lagarto spock</title>
	</head>
	<body>
		<br/>
		<div class="container col-md-3">
			<form action="http://localhost:8081/HolaSpringFrameWork/resolverJuego" method="GET">
				<select name="selOpcion" class="form-select">
					<c:forEach items="${opciones}" var="opcion">
							<option value="${opcion.getNumero()}">${opcion}</option>
					</c:forEach>
				</select>
				<br/>
				<button type="submit" class="btn btn-success"> Jugar!</button>
			</form>	
		</div>
	</body>
</html>