<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*,javax.sql.*,org.kosa.myproject.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbcp test</title>
</head>
<body>
<h3>Object Pool Design Pattern : DataBase Connection Pool (DBCP) </h3>
<%--  일반적인 기존 데이터베이스 컨넥션  --%>
<%
			Class.forName(DbConfig.DRIVER);
			Connection con1 = DriverManager.getConnection(DbConfig.URL,DbConfig.USER,DbConfig.PASS);
%>	기존의 생성하고 소멸시키는 컨넥션 <%=con1.getClass() %>
<hr>
<%
		Connection con2=DataSourceManager.getInstance().getDataSource().getConnection();
%>	DBCP 로부터 빌려오고 반납하는 컨넥션 <%=con2.getClass() %>
</body>
</html>









