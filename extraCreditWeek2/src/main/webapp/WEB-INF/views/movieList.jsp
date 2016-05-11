<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IMDB</title>
</head>
<body>
	<h1>IMDB - Movie List</h1>
	<table>
	<c:forEach var="movie" items="${movies}">
	<tr>
		<td>${movie.name}</td>
		<td>${movie.year}</td>
		<td>${movie.genre}</td>
		<td>${movie.rating}</td>
		<td><a href="movies/${movie.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addMovie"> Add a Movie</a>
</body>
</html>