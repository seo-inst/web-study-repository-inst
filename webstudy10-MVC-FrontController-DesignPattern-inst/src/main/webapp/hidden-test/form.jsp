<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hidden study를 위한 form</title>
</head>
<body>
<form method="post" action="hidden-result.jsp">
<%--
			사용자에게는 보이지 않는 태그 hidden 
			주로 다양한 요청을 서버에게 인식시키기 위한 정보를 전달할 때 사용된다 
 --%>
	<input type="hidden" name="command" value="register">
	<button type="submit">등록</button>
</form>
<hr>
<form method="get" action="hidden-result.jsp">
	<input type="hidden" name="command" value="findProductById">
	<button type="submit">검색</button>
</form>
</body>
</html>














