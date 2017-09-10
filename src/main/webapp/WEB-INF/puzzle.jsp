<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Пятнашки</title>
<link rel="stylesheet" href="main.css" />
<script src="https://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function move(wid, hid) {
		$.get("move?wid=" + wid + "&hid=" + hid, function() {
			$("#table").load("part.jsp");
			$("#winTitle").load("part2.jsp");
		});		
	}
</script>
</head>
<body>
<div class="main">
	<h1>Пятнашки</h1>
	<table id="table">
		<jsp:include page="/part.jsp" />
	</table>
	<form action="mix">
		<input type="submit" value="Перемешать">
	</form>
	<div id="winTitle">
		<jsp:include page="/part2.jsp" />
	</div>
	</div>
</body>
</html>