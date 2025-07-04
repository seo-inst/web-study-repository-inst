<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 기반의 ServletContext Test</title>
</head>
<body>
<h3>안녕하세요 저는 jsp 입니다</h3>
<%=config.getServletContext().getInitParameter("securityConfigInfo") %><br><br>
<%=config.getServletContext().getAttribute("securityRoleInfo") %>
</body>
</html>










