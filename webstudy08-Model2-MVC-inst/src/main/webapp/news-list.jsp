<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>news-list</title>
</head>
<body>
<ul>
<% 
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>)request.getAttribute("newsList");
		for(int i=0;i<list.size();i++){
%>
	<li><%=list.get(i) %></li>
<% 
		}
%>	
</ul>
</body>
</html>






