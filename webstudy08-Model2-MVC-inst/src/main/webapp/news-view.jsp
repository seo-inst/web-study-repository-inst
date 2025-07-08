<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>news-view</title>
</head>
<body>
<h2><%=request.getParameter("newsId") %>번 뉴스</h2>
<article>
	<p><%=request.getAttribute("newsInfo") %></p>
</article>
</body>
</html>