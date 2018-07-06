<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addAlien">	
		<input type="text" name = "aid">
		<input type="text" name = "aname">
		<input type="text" name = "tech">
		<input type="submit" name = "submit"><br><br><br>	
	</form>
	
	<form action="getAlien">	
		<input type="text" name = "aid">
		<input type="submit" name = "submit"><br><br><br>	
	</form>
	
	<form action="deleteAlien">	
		<input type="text" name = "aid">
		<input type="submit" name = "submit"><br><br><br>	
	</form><br><br>
	
	
	<p>Tech</p>
	<form action="findByTech">	
		<input type="text" name = "tech">
		<input type="submit" name = "submit"><br><br><br>	
	</form>
	

</body>
</html>