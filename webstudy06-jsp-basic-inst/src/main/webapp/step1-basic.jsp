<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp basic</title>
</head>
<body>
<!--  html 주석 -->
<%--  jsp 주석 --%>
jsp 기본 문법  <br><br><br>

<%--  멤버 변수를 선언   --%>
<%!  int count=1; %> 
<h3>접속수 : <%= count++ %></h3>
<strong><%=new Date().toString() %></strong>

<%--  아래 문장을 오십번 반복한다 --%>
<%
	 for(int i=0;i<50;i++){		
%>
<p><%=i+1 %>번 금요일이라 기쁩니다</p>
<%
	 }  
%>

</body>
</html>



















